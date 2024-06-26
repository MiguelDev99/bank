package com.example.bank.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "document_type")
@NamedQuery(name = "DocumentType.findAll", query = "SELECT d FROM DocumentType d")

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DocumentType implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "doty_id")
    @NotNull
    @Min(1)
    private Integer dotyId;

    @NotNull
    private String enable;

    @NotNull
    @NotEmpty
    @Size(min = 4, max = 255)
    private String name;

    @OneToMany(mappedBy = "documentType")
    private List<Customer> customers;

}
