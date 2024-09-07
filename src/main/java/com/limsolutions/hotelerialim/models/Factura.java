package com.limsolutions.hotelerialim.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity 
@Data 
public class Factura implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id_factura;
    
    @OneToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente id_cliente;

    @OneToOne
    @JoinColumn(name = "id_hotel", nullable = false)
    private Hotel id_hotel;

    @OneToOne
    @JoinColumn(name = "id_reservacion", nullable = false)
    private Reservacion id_reservacion;

    private Double impuestos;

    private Double tarifa;

    private Double total;



}
