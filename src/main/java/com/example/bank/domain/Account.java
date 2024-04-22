package com.example.bank.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "acco_id")
    private String accoId;

    private BigDecimal balance;

    private String enable;

    private String password;

    private Long version;

    @ManyToOne
    @JoinColumn(name = "cust_id")
    private Customer customer;

    @OneToMany(mappedBy = "account")
    private List<RegisteredAccount> registeredAccounts;

    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions;
}
