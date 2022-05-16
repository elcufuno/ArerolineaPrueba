package com.example.restservice.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "Origenes_X_Destinos")
public class OrigenesXDestinosEntity implements Serializable {

    private static final long serialVersionUID = 5478727925393900795L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Origenes_X_Destino")
    private String IdOrigenesXDestino;

    @Column(name = "Valor_Tiquiete")
    private Double ValorTiquiete;

    @Column(name = "Fecha_Ingreso")
    private Date FechaIngreso;

    @Column(name = "Estado")
    private Boolean Estado;

    @Column(name = "Id_Ciudad_Origen")
    private Integer IdCiudadOrigen;

    @Column(name = "Id_CiudadDestino")
    private Integer IdCiudadDestino;


}
