package com.limsolutions.hotelerialim.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@Entity
@Table(name = "hotel")

public class Hotel implements Serializable{

    @Id
    @Column(name = "id_hotel")
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
    private Pais pais;


    @OneToMany
    @JoinColumn(name = "id_ciudad", nullable = false)
    private Ciudad ciudad;

    


}
