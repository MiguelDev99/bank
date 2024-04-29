package com.example.bank.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@NamedQuery(name = "Customer.findAll",query = "SELECT c FROM Customer c")

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "cust_id")
    @NotNull
    @Min(1)
    private Integer custId;

    @NotNull
    @NotEmpty
    @Size(min = 4, max = 255)
    private String address;

    @NotNull
    @NotEmpty
    @Size(min = 4, max = 255)
    @Email
    private String email;

    @NotNull
    private String enable;

    @NotNull
    @NotEmpty
    @Size(min = 4, max = 255)
    private String name;

    @NotNull
    @NotEmpty
    @Size(min = 4, max = 255)
    private String phone;

    private String token;

    @OneToMany(mappedBy = "customer")
    private List<Account> accounts;

    @ManyToOne
    @JoinColumn(name = "doty_id")
    private DocumentType documentType;

    @OneToMany(mappedBy = "customer")
    private List<RegisteredAccount> registeredAccounts;
}

