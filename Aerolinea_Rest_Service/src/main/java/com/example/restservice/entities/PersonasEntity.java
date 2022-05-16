package com.example.restservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Personas")
public class PersonasEntity {
    @Id
    @Column(name = "Identificacion")
    private String identificacion;

    @Column(name = "Nombres")
    private String nombres;

    @Column(name = "Apellidos")
    private String apellidos;

    @Column(name = "Edad")
    private Integer edad;

    @Column(name = "Email")
    private String email;

    @Column(name = "Genero")
    private String genero;

    @Column(name = "Direccion")
    private String direccion;
}
