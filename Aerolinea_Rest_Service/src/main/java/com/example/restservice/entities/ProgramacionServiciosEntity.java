package com.example.restservice.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "Programacion_Servicios")
public class ProgramacionServiciosEntity implements Serializable {

    private static final long serialVersionUID = 5478727925393900795L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Programacion_Servicio")
    private String IdProgramacionServicio;

    @Column(name = "Ciudad_Origen")
    private String CiudadOrigen;

    @Column(name = "Ciudad_Destino")
    private String CiudadODestino;

    @Column(name = "Fecha_Salida")
    private String FechaSalida;

    @Column(name = "Hora_Salida")
    private String HoraSalida;

    @Column(name = "Fecha_Regreso")
    private String FechaRegreso;

    @Column(name = "Hora_Regreso")
    private String HoraRegreso;

    @Column(name = "Escala_Vuelo")
    private String EscalaVuelo;

    @Column(name = "Ciudad_Escala")
    private String CiudadEscala;

    @Column(name = "Hora_Salida_Escala")
    private String HoraSalidaEscala;

    @Column(name = "Duracion_Vuelo")
    private String DuracionVuelo;

    @Column(name = "Fecha_Ingreso")
    private Date FechaIngreso;

    @Column(name = "Estado")
    private Boolean Estado;

}
