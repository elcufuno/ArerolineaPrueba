package com.example.restservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "Aviones")
public class AvionesEntity {

    @Id
    @Column(name = "Id_Avion")
    private Integer IdAvion;

    @Column(name = "Nombre")
    private String Nombre;

    @Column(name = "Cantidad_Sillas")
    private Integer CantidadSillas;

    @Column(name = "Codigo_Avion")
    private String CodigoAvion;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "Estado")
    private Double Estado;

}
