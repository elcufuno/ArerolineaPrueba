package com.example.restservice.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "Usuarios")
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 5478727925393900795L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "Usuario", length = 50)
    private String user;

    @Column(name = "Contrasena", length = 50)
    private String password;

    @Column(name = "Identificacion", length = 10)
    private String identification;
}
