package com.example.restservice.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UsuarioDTO {

    private String NumeroIdentificacion;
    private String Nombres;
    private String Apellidos;
    private String Celular;
    private String Correo;
    private Integer Edad;
    private String Genero;
    private String NumeroVisa;
    private Date FechaVencimentoVisa;
    private String MillasAcomuladas;
    private Integer IdTipoViajero;
    private Integer IdTipoDocumento;
    private Integer IdTipoUsuario;
}
