package com.example.bank.builder;

import com.example.bank.domain.Customer;
import com.example.bank.domain.DocumentType;
import com.example.bank.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DocumentTypeBuilder {

    public static DocumentType getDocumentType(){
        DocumentType documentType = DocumentType.builder()
                .dotyId(100)
                .name("PASAPORTE")
                .enable("Y")
                .build();
        return documentType;
    }

    public static DocumentType getDocumentType2(){
        DocumentType documentType = DocumentType.builder()
                .dotyId(101)
                .name("CARNE DE IDENTIDAD")
                .enable("Y")
                .build();
        return documentType;
    }

    public static List<DocumentType> getDocumentTypes(){
        List<DocumentType> documentTypes = new ArrayList<>();
        documentTypes.add(getDocumentType());
        return documentTypes;
    }

    public static Optional<DocumentType> getDocumentTypeOptional(){
        Optional<DocumentType> documentType = Optional.of(getDocumentType());
        return documentType;
    }
}
