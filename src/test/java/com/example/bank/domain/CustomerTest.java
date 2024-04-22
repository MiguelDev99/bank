package com.example.bank.domain;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

//Para evitar que se borre el registro
@Rollback(false)
class CustomerTest {
    @Autowired
    EntityManager entityManager;

    @Test
    @Order(1)
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)

    void debeCrearUnCustomer(){
        //Arrange
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

        DocumentType documentType = entityManager.find(DocumentType.class, 1);

        customer.setDocumentType(documentType);

        //Act
        entityManager.persist(customer);

        //Assert
        assertNotNull(customer);
    }

    @Test
    @Order(2)
    void debeConsultarUnCustomer(){
        //Arrange
        Customer customer = null;

        //Act
        customer = entityManager.find(Customer.class,2020);

        //Assert
        assertNotNull(customer);
    }

    @Test
    @Order(3)
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    void debeModificarUnCustomer(){
        //Arrange
        Customer customer = null;
        customer = entityManager.find(Customer.class,2020);

        //Act
        customer.setName("Miguel");
        entityManager.merge(customer);

        //Assert
        assertNotNull(customer);
    }

    @Test
    @Order(4)
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    void debeEliminarUnCustomer(){
        //Arrange
        Customer customer = null;
        customer = entityManager.find(Customer.class,2020);

        //Act
        entityManager.remove(customer);

        //Assert
        assertNotNull(customer);
    }
}