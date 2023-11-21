package com.procesos.tienda.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "firstname is required")
    @Size(max = 255,message = "firstname max 255 characters")
    private String firstName;
    @NotNull(message = "lastname is required")
    @Size(max = 255,message = "lastname max 255 characters")
    private String lastName;
    @NotNull(message = "document is required")
    @Size(min = 5, max = 15, message = "document min 5 characters and max 15")
    private String document;
    private String phone;
    @NotNull(message = "email is required")
    @Email(message = "email not valid")
    private String email;
    @NotNull(message = "password is required")
    @Size(min = 8, message = "password min 8 characters")
    private String password;
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    List<Address> addressList;
    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return this.email;
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
