package com.limsolutions.hotelerialim.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;


@Entity

public class Hotel {

    @Id
    @Column(name = "id_Hotel")
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    private Long id_hotel;


    private String nombre;

    private Long calificacion;

    private String direccion;

    private String correo;

    private Long telefono;

    private double ingresos;

    @NotBlank(message = "Ingrese una fotografia del hotel")
    private String hotelPhoto;


    @OneToOne
    @JoinColumn(name = "id_pais", nullable = false )
    private String pais;


    @OneToMany
    @JoinColumn(name = "id_ciudad", nullable = false)
    private String ciudad;

    


}
