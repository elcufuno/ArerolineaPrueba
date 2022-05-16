package com.example.restservice.dto;

import lombok.Data;

@Data
public class ProgramacionServiciosDTO {

    private String CiudadOrigen;
    private String CiudadODestino;
    private String FechaSalida;
    private String HoraSalida;
    private String FechaRegreso;
    private String HoraRegreso;
    private String EscalaVuelo;
    private String CiudadEscala;
    private String HoraSalidaEscala;
    private String DuracionVuelo;
}
