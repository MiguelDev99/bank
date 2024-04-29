package com.example.bank.builder;

import com.example.bank.domain.Customer;
import java.util.UUID;

public class CustomerBuilder {
    public static Customer getCustomer(){
        Customer customer = Customer.builder()
                .custId(3000)
                .name("Customer 1")
                .address("Calle de la fortuna")
                .phone("+57-3224343434")
                .email("customer1@correo.com")
                .token(UUID.randomUUID().toString().toUpperCase())
                .enable("Y")
                .documentType(DocumentTypeBuilder.getDocumentType())
                .build();
        return customer;
    }
}
