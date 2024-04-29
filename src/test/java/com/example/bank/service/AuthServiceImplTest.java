package com.example.bank.service;

import com.example.bank.controller.auth.AuthResponse;
import com.example.bank.controller.auth.LoginRequest;
import com.example.bank.controller.auth.RegisterRequest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Rollback(false)
public class AuthServiceImplTest {

    @Autowired
    AuthServiceImpl authServiceImpl;


    @Test
    @Order(1)
    void registroExitoso() {
        //Arrange
        RegisterRequest request = RegisterRequest.builder()
                .userEmail("test1@example.com")
                .name("Test User 1")
                .password("password")
                .userType(1)
                .build();

        //Act
        AuthResponse response = authServiceImpl.register(request);

        //Assert
        assertNotNull(response);
        assertNotNull(response.getToken());
    }

    @Test
    @Order(2)
    void loginExitoso() {
        //Arrange
        LoginRequest request = LoginRequest.builder()
                .userEmail("test@example.com")
                .password("password")
                .build();

        //Act
        AuthResponse response = authServiceImpl.login(request);

        //Assert
        assertNotNull(response);
        assertNotNull(response.getToken());
    }

    /*@Test
    @Order(3)
    void loginFallo() {
        LoginRequest request = new LoginRequest();
        request.setUserEmail("test@example.com");
        request.setPassword("asdasdadas");

        assertThrows(BadCredentialsException.class, () -> authServiceImpl.login(request));
    }

    @Test
    @Order(4)
    void registroConEmailDuplicado() {
        RegisterRequest request = new RegisterRequest();
        request.setUserEmail("test@example.com");
        request.setName("Otro Test User");
        request.setPassword("password");
        request.setUserType(1);

        assertThrows(IllegalArgumentException.class, () -> authServiceImpl.register(request));
    }*/
}
