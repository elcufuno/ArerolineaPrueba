package com.example.restservice.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "Tipo_Documento")
public class TipoDocumentoEntity implements Serializable {

    private static final long serialVersionUID = 5478727925393900795L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Tipo_Documento")
    private Integer IdTipoDocumento;

    @Column(name = "Nombre")
    private String Nombre;

    @Column(name = "Fecha_Ingreso")
    private Date FechaIngreso;

    @Column(name = "Estado")
    private Boolean Estado;

}
