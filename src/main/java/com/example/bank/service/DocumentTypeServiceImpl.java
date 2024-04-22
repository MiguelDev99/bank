package com.example.bank.service;

import com.example.bank.domain.DocumentType;
import com.example.bank.repository.DocumentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentTypeServiceImpl implements DocumentTypeService{
    @Autowired
    DocumentTypeRepository documentTypeRepository;


    @Override
    @Transactional(readOnly = true)
    public List<DocumentType> findAll() {
        return documentTypeRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<DocumentType> findById(Integer integer) {
        return documentTypeRepository.findById(integer);
    }

    @Override
    public Long count() {
        return documentTypeRepository.count();
    }

    @Override
    public void validate(DocumentType entity) throws Exception {

    }

    @Override
    public DocumentType save(DocumentType entity) throws Exception {
        return null;
    }

    @Override
    public DocumentType update(DocumentType entity) throws Exception {
        return null;
    }

    @Override
    public void delete(DocumentType entity) throws Exception {

    }

    @Override
    public void deleteById(Integer integer) throws Exception {

    }
}
