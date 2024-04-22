package com.example.bank.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDTO {

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

    @NotNull
    @Min(0)
    private Integer dotyId;
}
