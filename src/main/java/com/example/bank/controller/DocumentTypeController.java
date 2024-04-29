package com.example.bank.controller;

import com.example.bank.domain.Customer;
import com.example.bank.domain.DocumentType;
import com.example.bank.dto.CustomerDTO;
import com.example.bank.dto.DocumentTypeDTO;
import com.example.bank.mapper.DocumentTypeMapper;
import com.example.bank.service.DocumentTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/document-type")
@RequiredArgsConstructor
@CrossOrigin("*")
public class DocumentTypeController {

    @Autowired
    DocumentTypeService documentTypeService;

    @Autowired
    DocumentTypeMapper documentTypeMapper;

    @GetMapping
    public ResponseEntity<?> findAll() throws Exception{
        List<DocumentType> documentTypes = documentTypeService.findAll();
        List<DocumentTypeDTO> documentTypeDTOs=documentTypeMapper.toDocumentTypeDTOs(documentTypes);

        return ResponseEntity.ok().body(documentTypeDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Integer id) throws Exception{
        DocumentType documentType = null;
        DocumentTypeDTO documentTypeDTO = null;

        Optional<DocumentType> documentTypeOptional = documentTypeService.findById(id);

        if (documentTypeOptional.isEmpty()){
            return ResponseEntity.ok().body(null);
        }
        documentType = documentTypeOptional.get();
        documentTypeDTO = documentTypeMapper.toDocumentTypeDTO(documentType);

        return ResponseEntity.ok().body(documentTypeDTO);
    }
}
