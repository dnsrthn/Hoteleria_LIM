package com.limsolutions.hotelerialim.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity 
@Data 
public class Factura implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id_factura;

    @NotBlank(message = "Necesita llenar el campo de Impuestos")
    private Double impuestos;

    @NotBlank(message = "Necesita llenar el campo de tarifa")
    private Double tarifa;

    @NotBlank(message = "Necesita llenar el campo de total")
    private Double total;
    
    @OneToOne
    @JoinColumn(nullable = false)
    private Cliente id_cliente;

    @OneToOne
    @JoinColumn(nullable = false)
    private Hotel id_hotel;

    @OneToOne
    @JoinColumn(nullable = false)
    private Reservacion id_reservacion;



}
