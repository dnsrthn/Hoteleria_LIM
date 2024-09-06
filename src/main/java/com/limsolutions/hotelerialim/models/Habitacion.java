package com.limsolutions.hotelerialim.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;


@Entity
@Data
@Table(name = "Habitaciones")
public class Habitacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Habitaciones")
    private Long id_Habitaciones;

    @JoinColumn(name = "id_hotel", nullable = false)
    private Hotel hotel;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "numero")
    private String numero;

    @Column(name = "estado")
    private String estado;

    @Column(name = "precio")
    private double precio;

    @ManyToOne
    @Column(name = "servicios", nullable = false)
    private Servicios servicios;

}