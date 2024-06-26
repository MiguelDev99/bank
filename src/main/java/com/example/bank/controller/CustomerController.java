package com.example.bank.controller;

import com.example.bank.domain.Customer;
import com.example.bank.dto.CustomerDTO;
import com.example.bank.mapper.CustomerMapper;
import com.example.bank.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid CustomerDTO customerDTO)throws Exception{
        Customer customer = customerMapper.toCustomer(customerDTO);

        customer = customerService.save(customer);
        customerDTO = customerMapper.toCustomerDTO(customer);

        return ResponseEntity.ok().body(customerDTO);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid CustomerDTO customerDTO)throws Exception{
        Customer customer = customerMapper.toCustomer(customerDTO);

        customer = customerService.update(customer);
        customerDTO = customerMapper.toCustomerDTO(customer);

        return ResponseEntity.ok().body(customerDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) throws Exception{

        customerService.deleteById(id);

        return ResponseEntity.ok().body(null);
    }

    @GetMapping
    public ResponseEntity<?> findAll() throws Exception{
        List<Customer> customers = customerService.findAll();
        List<CustomerDTO> customerDTOs=customerMapper.toCustomerDTOs(customers);

        return ResponseEntity.ok().body(customerDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Integer id) throws Exception{
        Customer customer = null;
        CustomerDTO customerDTO = null;

        Optional<Customer> customerOptional = customerService.findById(id);

        if (customerOptional.isEmpty()){
            return ResponseEntity.ok().body(null);
        }
        customer = customerOptional.get();
        customerDTO = customerMapper.toCustomerDTO(customer);

        return ResponseEntity.ok().body(customerDTO);
    }
}
