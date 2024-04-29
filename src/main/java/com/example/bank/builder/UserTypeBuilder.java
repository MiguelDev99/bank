package com.example.bank.builder;

import com.example.bank.domain.UserType;
import com.example.bank.dto.UserTypeDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserTypeBuilder {
    public static UserType getUserType(){
        UserType userType = UserType.builder()
                .ustyId(100)
                .name("TESORERO")
                .enable("Y")
                .build();
        return userType;
    }

    public static UserType getUserType2(){
        UserType userType = UserType.builder()
                .ustyId(101)
                .name("EJECUTIVO")
                .enable("Y")
                .build();
        return userType;
    }

    public static List<UserType> getUsersTypes(){
        List<UserType> userTypes = new ArrayList<>();
        userTypes.add(getUserType());
        return userTypes;
    }

    public static Optional<UserType>getUserTypeOptional(){
        Optional<UserType> userTypeOptional = Optional.of(getUserType());
        return userTypeOptional;
    }

    public static UserTypeDTO getUserTypeDTO(){
        UserTypeDTO userType = new UserTypeDTO();
        userType.setUstyId(95);
        userType.setName("ASESOR");
        userType.setEnable("Y");
        return userType;
    }

    public static Optional<UserTypeDTO> getUserTypeDTOOptional(){
        Optional<UserTypeDTO> userOptional = Optional.of(getUserTypeDTO());
        return userOptional;
    }

    public static List<UserTypeDTO> getUsersTypesDTOs(){
        List<UserTypeDTO> users = new ArrayList<>();
        users.add(getUserTypeDTO());
        return users;
    }
}
