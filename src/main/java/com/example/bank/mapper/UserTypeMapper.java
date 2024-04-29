package com.example.bank.mapper;

import com.example.bank.domain.UserType;
import com.example.bank.dto.DocumentTypeDTO;
import com.example.bank.dto.UserTypeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserTypeMapper {
    UserTypeMapper INSTANCE = Mappers.getMapper(UserTypeMapper.class);

    UserTypeDTO toUserTypeDTO(UserType userType);

    UserType toUserType(DocumentTypeDTO documentTypeDTO);

    List<UserTypeDTO> toUserTypeDTOs(List<UserType> userTypes);

    List<UserType> toUserTypes(List<UserTypeDTO> userTypeDTOs);

}
