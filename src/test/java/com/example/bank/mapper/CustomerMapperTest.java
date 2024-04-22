package com.example.bank.mapper;

import com.example.bank.domain.Customer;
import com.example.bank.dto.CustomerDTO;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerMapperTest {

    @Autowired
    CustomerMapper customerMapper;

    @Test
    void debeMapearDeCustomerDTOaCustomer(){
        //Arrange
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setAddress("Avenida 6 #10-34");
        customerDTO.setCustId(2020);
        customerDTO.setEmail("miguel@gmail.com");
        customerDTO.setEnable("T");
        customerDTO.setName("Pablo");
        customerDTO.setPhone("1231312313");
        customerDTO.setToken(UUID.randomUUID().toString().toUpperCase());
        customerDTO.setDotyId(1);

        Customer customer = null;

        //Act
        //customer=customerMapper.toCustomer(customerDTO);

        //Assert
        assertNotNull(customer);
    }
}
