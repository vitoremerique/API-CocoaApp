package com.api.cocoa.model;

import com.api.cocoa.DTO.UsuarioDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", unique = true)

    private String name;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "password")
    private String password;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
