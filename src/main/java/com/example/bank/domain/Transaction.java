package com.example.bank.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@NamedQuery(name = "Transaction.findAll", query = "SELECT t FROM Transaction t")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "tran_id")
    private Integer tranId;

    private BigDecimal amount;

    private Timestamp date;

    @ManyToOne
    @JoinColumn(name = "acco_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "trty_id")
    private TransactionType transactionType;

    @ManyToOne
    @JoinColumn(name = "user_email")
    private User user;
}
