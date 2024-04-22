package com.example.bank.repository;

import com.example.bank.domain.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentTypeRepository extends JpaRepository<DocumentType,Integer> {
}
