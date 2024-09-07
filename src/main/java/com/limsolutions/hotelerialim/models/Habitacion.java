package com.limsolutions.hotelerialim.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Entity
@Data
@Table(name = "Habitacion")
public class Habitacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_habitacion")
    private Long id_habitacion;

    @JoinColumn(name = "id_hotel", nullable = false)
    private Hotel id_hotel;

    @Column(name = "tipo")
    @NotBlank(message = "El tipo de habitacion es obligatorio")
    private String tipo;

    @Column(name = "numero")
    @NotBlank(message = "El numero de habitacion es obligatorio")
    private String numero;

    @Column(name = "estado")
    @NotBlank(message = "El estado es obligatorio")
    private String estado;

    @Column(name = "precio")
    @NotBlank(message = "El precio es obligatorio")
    private double precio;

    @ManyToOne
    @JoinColumn(name = "id_servicio",  nullable = false)
    private Servicio id_servicio;

}