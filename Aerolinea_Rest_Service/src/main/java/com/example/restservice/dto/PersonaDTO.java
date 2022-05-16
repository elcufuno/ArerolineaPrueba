package com.example.restservice.dto;

import lombok.Data;

@Data
public class PersonaDTO {
    private String identificacion;
    private String nombres;
    private Integer edad;
    private String email;
    private String genero;
    private String direccion;
    private String apellidos;
}
