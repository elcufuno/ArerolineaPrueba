package com.example.restservice.dto;

import lombok.Data;

@Data
public class VuelosXAvionesXUsuarioDTO {

    private Double DesceuntoValorViajero;
    private Double DesceuntoValor65;
    private Double DesceuntoValor2;
    private String TipoVuelo;
    private String TitularReserva;
    private String MetodoPago;
    private Double Subtotal;
    private Double TotalPagadoTiquite;
    private Integer IdUsuario;
    private Integer IdSillasAvion;
    private Integer IdProgramacionServicio;
}
