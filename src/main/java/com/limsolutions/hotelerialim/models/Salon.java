package com.limsolutions.hotelerialim.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data
@Table(name = "salon")
public class Salon implements Serializable {

    private static final long serialVersionUID = 1L; // versión de serialización

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_salon")
    private Long id_salon;

    @Column(name = "id_hotel", nullable = false)
    private Long id_hotel; // id del hotel como clave foránea

    @Column(name = "id_servicio", nullable = false)
    private Long id_servicio; // id del servicio como clave foránea

    @NotBlank(message = "El nombre no puede estar en blanco")
    @Column(name = "nombre")
    private String nombre;

    @NotNull(message = "La capacidad no puede ser nula")
    @Column(name = "capacidad", nullable = false)
    private Integer capacidad;

    @Column(name = "descripcion")
    private String descripcion;

}