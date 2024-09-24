package com.limsolutions.hotelerialim.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor 
@Entity
@Data
@Table(name = "Hotel")
public class Hotel implements Serializable{


    @Id
    @Column(name = "id_hotel")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id_hotel;


    @NotBlank(message = "El nombre es obligatorio")
    @Column(unique = true)
    private String nombre;

    @NotNull(message = "La calificacion es obligatoria")
    private Long calificacion;

    @NotBlank(message = "Ingrese una direccion")
    @Column(unique = true)
    private String direccion;

    @Email(message = "Debe ingresar un email valido")
    @Column(unique = true)
    private String correo;

    @NotBlank(message = "Ingrese el numero telefonico")
    private String telefono;

    @NotNull(message = "Ingrese los ingresos generados")
    private double ingresos;


    @NotBlank(message = "Ingrese una fotografia del hotel")
    private String hotelPhoto;

    @NotBlank(message = "Ingrese el estado del hotel")
    private String estado;

    @OneToOne
    @JoinColumn(name = "id_ciudad", nullable = false)
    private Ciudad id_ciudad;

    public Hotel(String estado){
        this.estado = estado;
    }

}

    
