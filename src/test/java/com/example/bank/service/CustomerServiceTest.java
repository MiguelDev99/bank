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
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Rollback(false)
public class CustomerServiceTest {
    @Autowired
    CustomerService customerService;

    @Autowired
    DocumentTypeService documentTypeService;

    @Test
    @Order(1)
    //No va porque el service ya los tiene
    //@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    void debeCrearUnCustomer() throws Exception{
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

        Optional<DocumentType> documentTypeOptional = documentTypeService.findById(1);
        if(documentTypeOptional.isPresent()){
            documentType=documentTypeOptional.get();
        }

        customer.setDocumentType(documentType);

        //Act
        customerService.save(customer);

        //Assert
        assertNotNull(customer);
    }

    @Test
    @Order(2)
    void debeConsultarUnCustomer() throws Exception{
        //Arrange
        Optional<Customer> customerOptional=null;

        //Act
        customerOptional = customerService.findById(2020);

        //Assert
        assertTrue(customerOptional.isPresent());
    }

    @Test
    @Order(3)
    //@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    void debeModificarUnCustomer() throws Exception{
        //Arrange
        Optional<Customer> customerOptional=null;
        Customer customer = null;
        customerOptional = customerService.findById(2020);
        assertTrue(customerOptional.isPresent());

        customer=customerOptional.get();
        customer.setName("Pablo");

        //Act
        customerService.update(customer);

        //Assert
        assertEquals("Pablo", customer.getName());
    }

    @Test
    @Order(4)
    //@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    void debeEliminarUnCustomer() throws Exception{
        //Arrange
        Optional<Customer> customerOptional=null;
        Customer customer = null;
        customerOptional = customerService.findById(2020);
        assertTrue(customerOptional.isPresent());
        customer=customerOptional.get();

        //Act
        customerService.delete(customer);
    }
}
