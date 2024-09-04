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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Entity
@Data
@Table(name = "hotel")

public class Hotel implements Serializable{


    @Id
    @Column(name = "id_hotel")
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    private Long id_hotel;


    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "La calificacion es obligatoria")
    private Long calificacion;


    @NotBlank(message = "Ingrese una direccion")
    private String direccion;

    @Email(message = "Debe ingresar un email valido")
    private String correo;

    @NotBlank(message = "Ingrese un telefono valido")
    private Long telefono;

    @NotBlank(message = "Los ingresos son obligatorias")
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

    
