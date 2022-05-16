package com.example.restservice.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "Usuarios")
public class UsuarioEntity implements Serializable {

    private static final long serialVersionUID = 5478727925393900795L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Usuario")
    private Integer IdUsuario;

    @Column(name = "Numero_Identificacion ")
    private String NumeroIdentificacion;

    @Column(name = "Nombres")
    private String Nombres;

    @Column(name = "Apellidos")
    private String Apellidos;

    @Column(name = "Celular")
    private String Celular;

    @Column(name = "Correo")
    private String Correo;

    @Column(name = "Edad")
    private Integer Edad;

    @Column(name = "Genero")
    private String Genero;

    @Column(name = "Numero_Visa")
    private String NumeroVisa;

    @Column(name = "Fecha_Vencimento_Visa")
    private Date FechaVencimentoVisa;

    @Column(name = "Millas_Acomuladas")
    private String MillasAcomuladas;

    @Column(name = "Fecha_Ingreso")
    private Date FechaIngreso;

    @Column(name = "Estado")
    private Boolean Estado;

    @Column(name = "Id_tipo_viajero")
    private Integer IdTipoViajero;

    @Column(name = "Id_Tipo_Documento")
    private Integer IdTipoDocumento;

    @Column(name = "Id_Tipo_Usuario")
    private Integer IdTipoUsuario;

}
