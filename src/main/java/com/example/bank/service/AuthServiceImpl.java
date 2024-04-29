package com.example.bank.service;

import com.example.bank.controller.auth.*;
import com.example.bank.domain.User;
import com.example.bank.domain.UserType;
import com.example.bank.repository.UserRepository;
import com.example.bank.repository.UserTypeRepository;
import com.example.bank.security.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final UserTypeRepository userTypeRepository;
    private final EmailService emailService;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserEmail(), request.getPassword()));
        UserDetails userDetails  = userRepository.findByUserEmail(request.getUserEmail()).orElseThrow();
        /*if (!request.getPassword().equals(request.getPassword())) {
            throw new BadCredentialsException("Bad credentials");
        }*/

        String token = jwtService.getToken(userDetails );
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByUserEmail(request.getUserEmail())) {
            throw new IllegalArgumentException("Email is already registered");
        }

        Integer userTypeId = request.getUserType();

        UserType userType = userTypeRepository.findById(userTypeId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user type ID"));


        User user = User.builder()
                .userEmail(request.getUserEmail())
                .name(request.getName())
                .password(passwordEncoder.encode(request.getPassword()))
                .enable("Y")
                .userType(userType)
                .build();

        user = userRepository.save(user);

        String token = jwtService.getToken(user);

        user.setToken(token);
        userRepository.save(user);

        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public ForgotPasswordResponse forgotPassword(ForgotPasswordRequest request) {
        try {
            User user = userRepository.findByUserEmail(request.getEmail())
                    .orElseThrow(() -> new IllegalArgumentException("User not found"));

            String newPassword = "Abc123!@#";
            user.setPassword(passwordEncoder.encode(newPassword));

            userRepository.save(user);

            String subject = "Recuperación de contraseña";
            String text = "Tu nueva contraseña es: " + newPassword;
            emailService.sendEmail(request.getEmail(), subject, text);
            return ForgotPasswordResponse.builder()
                    .message("La contraseña se restablecio correctamente.")
                    .build();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error resetting password", e);
        }
    }
}
