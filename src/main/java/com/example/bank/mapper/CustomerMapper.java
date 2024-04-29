package com.example.bank.mapper;

import com.example.bank.domain.Customer;
import com.example.bank.dto.CustomerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface CustomerMapper {

    @Mapping(source = "documentType.dotyId", target = "dotyId")
    public CustomerDTO toCustomerDTO(Customer customer);

    @Mapping(source = "dotyId", target = "documentType.dotyId")
    public Customer toCustomer(CustomerDTO customerDTO);

    public List<CustomerDTO> toCustomerDTOs(List<Customer> customers);

    public List<Customer> toCustomers(List<CustomerDTO> customerDTOs);
}
