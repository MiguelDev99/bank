package com.example.bank.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user_type")
@NamedQuery(name = "UserType.findAll",query = "SELECT u FROM UserType u")

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserType implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "usty_id")
    private Integer ustyId;

    private String enable;

    private String name;

    @OneToMany(mappedBy = "userType")
    private List<User> users;
}
