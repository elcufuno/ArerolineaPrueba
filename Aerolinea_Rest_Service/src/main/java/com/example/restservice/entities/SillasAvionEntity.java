package com.example.restservice.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "Sillas_Avion")
public class SillasAvionEntity implements Serializable {

    private static final long serialVersionUID = 5478727925393900795L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Sillas_Avion")
    private Integer IdSillasAvion;

    @Column(name = "Nombre")
    private String Nombre;

    @Column(name = "Numero_Sillas")
    private Integer NumeroSillas;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "Estado")
    private Boolean Estado;

    @Column(name = "Id_Avion")
    private Integer IdAvion;

}
