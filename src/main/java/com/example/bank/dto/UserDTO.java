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
public class UserDTO {

    @NotNull
    @NotEmpty
    @Size(min = 4, max = 255)
    @Email
    private String userEmail;

    @NotNull
    private String enable;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 255)
    private String name;

    private String token;

    @NotBlank(message = "La contraseña no puede estar en blanco")
    /*@Size(min = 8, max = 20, message = "La contraseña debe tener entre 8 y 20 caracteres")
    @Pattern.List({
            @Pattern(regexp = ".*[a-z].*", message = "La contraseña debe contener al menos una letra minuscula"),
            @Pattern(regexp = ".*[A-Z].*", message = "La contraseña debe contener al menos una letra mayuscula"),
            @Pattern(regexp = ".*\\d.*", message = "La contraseña debe contener al menos un digito"),
            @Pattern(regexp = ".*[!@#$%^&*()].*", message = "La contraseña debe contener al menos un simbolo")
    })*/
    private String password;

    @NotNull
    @Min(0)
    private Integer ustyId;
}
