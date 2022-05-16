package com.example.restservice.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "Vuelos_X_Aviones_X_Usuario")
public class VuelosXAvionesXUsuarioEntity implements Serializable {

    private static final long serialVersionUID = 5478727925393900795L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Vuelos_X_Aviones_X_Usuario")
    private Integer IdVuelosXAvionesXUsuario;

    @Column(name = "Desceunto_Valor_Viajero")
    private Double DesceuntoValorViajero;

    @Column(name = "Desceunto_Valor65")
    private Double DesceuntoValor65;

    @Column(name = "Desceunto_Valor2")
    private Double DesceuntoValor2;

    @Column(name = "Tipo_Vuelo")
    private String TipoVuelo;

    @Column(name = "Titular_Reserva")
    private String TitularReserva;

    @Column(name = "Metodo_Pago")
    private String MetodoPago;

    @Column(name = "Subtotal")
    private Double Subtotal;

    @Column(name = "Total_Pagado_Tiquite")
    private Double TotalPagadoTiquite;

    @Column(name = "Fecha_Ingreso")
    private Date FechaIngreso;

    @Column(name = "Estado")
    private Boolean Estado;

    @Column(name = "Id_Usuario")
    private Integer IdUsuario;

    @Column(name = "Id_Sillas_Avion")
    private Integer IdSillasAvion;

    @Column(name = "Id_Programacion_Servicio")
    private Integer IdProgramacionServicio;

}
