package com.example.bank.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "transaction_type")
@NamedQuery(name = "TransactionType.findAll", query = "SELECT t FROM TransactionType t")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionType implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "trty_id")
    private Integer trtyId;

    private String enable;

    private String name;

    @OneToMany(mappedBy = "transactionType")
    private List<Transaction> transactions;
}
