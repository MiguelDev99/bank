package com.example.bank.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "registered_account")
@NamedQuery(name = "RegisteredAccount.findAll", query = "SELECT r FROM RegisteredAccount r")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisteredAccount implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "reac_id")
    private Integer reacId;

    private String enable;

    @ManyToOne
    @JoinColumn(name = "acco_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "cust_id")
    private Customer customer;
}
