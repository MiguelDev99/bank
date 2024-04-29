package com.example.bank.mapper;

import com.example.bank.domain.User;
import com.example.bank.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface UserMapper {

    @Mapping(source = "userType.ustyId", target = "ustyId")
    public UserDTO toUserDTO(User user);

    @Mapping(source = "ustyId", target = "userType.ustyId")
    public User toUser(UserDTO userDTO);

    public List<UserDTO> toUserDTOs(List<User> users);

    public List<User> toUsers(List<UserDTO> userDTOs);
}
