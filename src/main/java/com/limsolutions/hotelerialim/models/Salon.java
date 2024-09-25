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
@Table(name = "Salon")
public class Salon implements Serializable {

    private static final long serialVersionUID = 1L; // versión de serialización

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_salon")
    private Long id_salon;

    @NotBlank(message = "El nombre no puede estar en blanco")
    @Column(name = "nombre")
    private String nombre;

    @NotBlank(message = "La capacidad no puede ser nula")
    @Column(name = "capacidad")
    private Long capacidad;

    @NotBlank()
    @Column(name = "estado")
    private String estado;

    @Column(name = "descripcion")
    private String descripcion;
    
    @ManyToOne
    @JoinColumn(name = "id_hotel", nullable = false)
    private Hotel id_hotel; // id del hotel como clave foránea   

    @ManyToOne
    @JoinColumn(name = "id_servicio", nullable = false)
    private Servicio id_servicio; // id del servicio como clave foránea

}