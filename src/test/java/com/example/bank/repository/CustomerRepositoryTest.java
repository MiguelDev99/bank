package com.example.bank.repository;

import com.example.bank.domain.Customer;
import com.example.bank.domain.DocumentType;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Rollback(false)
public class CustomerRepositoryTest {

    //Se inyectaron los dos repositorios
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    DocumentTypeRepository documentTypeRepository;

    @Test
    @Order(1)
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    void debeCrearUnCustomer(){
        //Arrange
        DocumentType documentType = null;
        Customer customer = new Customer();
        customer.setAccounts(null);
        customer.setAddress("Cra 4 norte 34-38");
        customer.setCustId(2020);
        customer.setEmail("miguel@gmail.com");
        customer.setEnable("Y");
        customer.setName("Miguel Ojeda");
        customer.setPhone("32112121212");
        customer.setRegisteredAccounts(null);
        customer.setToken(UUID.randomUUID().toString().toUpperCase());

        Optional<DocumentType> documentTypeOptional = documentTypeRepository.findById(1);
        if(documentTypeOptional.isPresent()){
            documentType=documentTypeOptional.get();
        }

        customer.setDocumentType(documentType);

        //Act
        customerRepository.save(customer);

        //Assert
        assertNotNull(customer);
    }

    @Test
    @Order(2)
    void debeConsultarUnCustomer(){
        //Arrange
        Optional<Customer> customerOptional=null;

        //Act
        customerOptional = customerRepository.findById(2020);

        //Assert
        assertTrue(customerOptional.isPresent());
    }

    @Test
    @Order(3)
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    void debeModificarUnCustomer(){
        //Arrange
        Optional<Customer> customerOptional=null;
        Customer customer = null;
        customerOptional = customerRepository.findById(2020);
        assertTrue(customerOptional.isPresent());

        customer=customerOptional.get();
        customer.setName("Pablo");

        //Act
        customerRepository.save(customer);

        //Assert
        assertEquals("Pablo", customer.getName());
    }

    @Test
    @Order(4)
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    void debeEliminarUnCustomer(){
        //Arrange
        Optional<Customer> customerOptional=null;
        Customer customer = null;
        customerOptional = customerRepository.findById(2020);
        assertTrue(customerOptional.isPresent());
        customer=customerOptional.get();

        //Act
        customerRepository.delete(customer);
    }
}
