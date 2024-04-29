package com.example.bank.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "users")
@NamedQuery(name = "User.findAll",query = "SELECT u FROM User u")

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable, UserDetails {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "user_email")
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

    @OneToMany(mappedBy = "user")
    private List<Transaction> transactions;

    @ManyToOne
    @JoinColumn(name = "usty_id")
    private UserType userType;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (userType != null) {
            String roleName = "ROLE_" + userType.getName().toUpperCase();
            return Collections.singleton(new SimpleGrantedAuthority(roleName));
        } else {
            return Collections.emptyList();
        }
        //return List.of();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userEmail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
