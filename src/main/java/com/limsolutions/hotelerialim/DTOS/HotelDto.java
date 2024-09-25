package com.limsolutions.hotelerialim.DTOS;

import java.io.Serializable;

import com.limsolutions.hotelerialim.models.Ciudad;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class HotelDto implements Serializable{

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


    @NotBlank(message = "Ingrese el estado del hotel")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_ciudad", nullable = false)
    private Ciudad id_ciudad;
}
