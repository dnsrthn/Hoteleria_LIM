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
    private Long id_Factura;
    
    @OneToOne
    @JoinColumn(nullable = false)
    private Cliente id_Cliente;

    @OneToOne
    @JoinColumn(nullable = false)
    private Hotel id_Hotel;

    @OneToOne
    @JoinColumn(nullable = false)
    private Reservacion id_Reservacion;

    @NotBlank
    private Double impuestos;
    @NotBlank
    private Double tarifa;
    @NotBlank
    private Double total;



}
