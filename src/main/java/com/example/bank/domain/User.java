package com.example.bank.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
@NamedQuery(name = "User.findAll",query = "SELECT u FROM User u")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "user_email")
    private String userEmail;

    private String enable;

    private String name;

    private String token;

    @OneToMany(mappedBy = "user")
    private List<Transaction> transactions;

    @ManyToOne
    @JoinColumn(name = "usty_id")
    private UserType userType;
}
