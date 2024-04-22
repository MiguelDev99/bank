package com.example.bank.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "document_type")
@NamedQuery(name = "DocumentType.findAll", query = "SELECT d FROM DocumentType d")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentType implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "doty_id")
    private Integer dotyId;

    private String enable;

    private String name;

    @OneToMany(mappedBy = "documentType")
    private List<Customer> customers;

}
