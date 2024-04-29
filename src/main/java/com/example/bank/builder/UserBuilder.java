package com.example.bank.builder;

import com.example.bank.domain.User;
import com.example.bank.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserBuilder {
    public static User getUser(){
        User user = User.builder()
                .userEmail("ejemplo@correo.com")
                .enable("Y")
                .name("Ejemplo")
                .token(UUID.randomUUID().toString().toUpperCase())
                .password("ejemplo1123")
                .userType(UserTypeBuilder.getUserType())
                .build();
        return user;
    }

    public static User getUser2(){
        User user = User.builder()
                .userEmail("ejemplo2@correo.com")
                .enable("Y")
                .name("Ejemplo 2")
                .token(UUID.randomUUID().toString().toUpperCase())
                .password("ejemplo2123")
                .userType(UserTypeBuilder.getUserType())
                .build();
        return user;
    }

    public static List<User> getUsers(){
        List<User> users = new ArrayList<>();
        users.add(getUser());
        return users;
    }

    public static Optional<User> getUserOptional(){
        Optional<User> userOptional=Optional.of(getUser());
        return userOptional;
    }

    public static UserDTO getUserDTO(){
        UserDTO user = new UserDTO();
        user.setUserEmail("ejemplo3@correo.com");
        user.setEnable("Y");
        user.setName("Ejemplo 3");
        user.setToken(UUID.randomUUID().toString().toUpperCase());
        user.setPassword("ejemplo3123");
        user.setUstyId(102);
        return user;
    }

    public static Optional<UserDTO> getUserDTOOptional(){
        Optional<UserDTO> userOptional = Optional.of(getUserDTO());
        return userOptional;
    }

    public static List<UserDTO> getUsersDTOs(){
        List<UserDTO> users = new ArrayList<>();
        users.add(getUserDTO());
        return users;
    }

}
