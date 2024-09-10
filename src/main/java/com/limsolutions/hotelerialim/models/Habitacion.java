package com.limsolutions.hotelerialim.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;


@Entity
@Data
@Table(name = "Habitacion")
public class Habitacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_habitacion")
    private Long id_habitacion;

    @ManyToOne
    @JoinColumn(name = "id_hotel", nullable = false)
    private Hotel id_hotel;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "numero")
    private String numero;

    @Column(name = "estado")
    private String estado;

    @Column(name = "precio")
    private Double precio;

    @ManyToOne
    @JoinColumn(name = "id_servicio",  nullable = false)
    private Servicio id_servicio;

}