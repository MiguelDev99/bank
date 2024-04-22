package com.example.bank.service;

import com.example.bank.domain.Customer;
import com.example.bank.repository.CustomerRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    Validator validator;

    @Override
    public void validate(Customer entity) throws ConstraintViolationException {
        Set<ConstraintViolation<Customer>> constraintViolations = validator.validate(entity);
        if(!constraintViolations.isEmpty()){
            throw new ConstraintViolationException((constraintViolations));
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Customer> findById(Integer integer) {
        return customerRepository.findById(integer);
    }

    @Override
    @Transactional(readOnly = true)
    public Long count() {
        return customerRepository.count();
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Customer save(Customer entity) throws Exception {
        if(entity==null){
            throw new Exception("El Customer es nulo");
        }
        validate(entity);
        if (customerRepository.existsById(entity.getCustId())){
            throw new Exception("El Customer con id:"+entity.getCustId()+" ya existe");
        }
        return customerRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Customer update(Customer entity) throws Exception {
        if(entity==null){
            throw new Exception("El Customer es nulo");
        }
        validate(entity);
        if (!customerRepository.existsById(entity.getCustId())){
            throw new Exception("El Customer con id:"+entity.getCustId()+" no existe");
        }
        return customerRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void delete(Customer entity) throws Exception {
        if(entity==null){
            throw new Exception("El Customer es nulo");
        }
        if (entity.getCustId()==null || entity.getCustId()==0){
            throw new Exception("El Customer id nulo");
        }
        if (!customerRepository.existsById(entity.getCustId())){
            throw new Exception("El Customer con id:"+entity.getCustId()+" no existe");
        }
        customerRepository.findById(entity.getCustId()).ifPresent(customer -> {
            if (!customer.getAccounts().isEmpty()){
                throw new RuntimeException("El Customer tiene Accounts asociadas");
            }
            if (!customer.getRegisteredAccounts().isEmpty()){
                throw new RuntimeException("El Customer tiene RegisteredAccounts asociadas");
            }
        });
        customerRepository.deleteById(entity.getCustId());
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteById(Integer integer) throws Exception {
        if (integer == null || integer <= 0){
           throw new Exception("El id es nulo o menor igual a cero");
        }
        if (!customerRepository.existsById(integer)){
            throw new Exception("El Customer con id:"+integer+" no existe");
        }
        delete(customerRepository.findById(integer).get());
    }
}
