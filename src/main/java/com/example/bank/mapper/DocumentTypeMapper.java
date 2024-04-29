package com.example.bank.mapper;

import com.example.bank.domain.DocumentType;
import com.example.bank.dto.DocumentTypeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DocumentTypeMapper {
    DocumentTypeMapper INSTANCE = Mappers.getMapper(DocumentTypeMapper.class);

    DocumentTypeDTO toDocumentTypeDTO(DocumentType documentType);

    DocumentType toDocumentType(DocumentTypeDTO documentTypeDTO);

    List<DocumentTypeDTO> toDocumentTypeDTOs(List<DocumentType> documentTypes);

    List<DocumentType> toDocumentTypes(List<DocumentTypeDTO> documentTypeDTOs);
}
