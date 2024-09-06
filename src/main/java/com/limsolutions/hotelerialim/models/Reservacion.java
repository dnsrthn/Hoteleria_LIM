package com.limsolutions.hotelerialim.models;

import java.io.Serializable;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Reservacion")
public class Reservacion implements Serializable{
    @Id
    @Column(name = "id_reservacion", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_reservacion;

    @OneToOne
    @JoinColumn(name = "id_hotel", nullable = false)
    private Hotel hotel;

    @OneToOne
    @JoinColumn(name = "id_habitacion", nullable = false)
    private Habitacion habitacion;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente; 

    @Column(unique = false)
    private int dias;

    private String estado;
}
