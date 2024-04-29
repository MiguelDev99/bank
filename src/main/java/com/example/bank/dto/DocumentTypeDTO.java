package com.example.bank.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocumentTypeDTO {

    @NotNull
    @Min(1)
    private Integer dotyId;

    @NotNull
    private String enable;

    @NotNull
    @NotEmpty
    @Size(min = 4, max = 255)
    private String name;
}
