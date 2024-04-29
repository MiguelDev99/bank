package com.example.bank.service;

import com.example.bank.domain.Customer;
import com.example.bank.domain.DocumentType;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Rollback(false)
public class DocumentTypeServiceTest {

    @Autowired
    DocumentTypeService documentTypeService;

    @Test
    @Order(1)
    void debeConsultarUnDocumentType() throws Exception{
        //Arrange
        Optional<DocumentType> documentTypeOptional=null;

        //Act
        documentTypeOptional = documentTypeService.findById(2);

        //Assert
        assertTrue(documentTypeOptional.isPresent());
    }
}
