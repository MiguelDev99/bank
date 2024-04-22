package com.example.bank.repository;

import com.example.bank.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

//aqui se proporciona una interfaz orientada a objetos para realizar operaciones CRUD (crear,leer,actualizar y eliminar) en los datos de la aplicacion
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
