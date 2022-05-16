package com.example.restservice.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "Paises")
public class PaisesEntity implements Serializable {

    private static final long serialVersionUID = 5478727925393900795L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Pais")
    private Integer IdPais;

    @Column(name = "Nombre")
    private String Nombre;

    @Column(name = "Operacio_Estado")
    private Boolean OperacioEstado;

    @Column(name = "Requiere_Visa")
    private Boolean RequiereVisa;

    @Column(name = "Fecha_Ingreso")
    private Date FechaIngreso;

    @Column(name = "Estado")
    private Boolean Estado;

}
