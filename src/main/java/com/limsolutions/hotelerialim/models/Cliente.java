package com.limsolutions.hotelerialim.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity 
@Data 
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id_cliente;

    @NotBlank(message = "ingresa el nombre completo es obligatorio")
    private String nombreCompleto;

    @Email(message="ingresa un email valido")
    @NotBlank(message = "Necesita llenar el campo de correo electronico")
    @Column(unique = true)
    private String correo; 

    @NotBlank(message = "ingresa el estado es obligatorio")
    private String estado;

    @NotBlank(message = "Necesita llenar el campo del numero telefonico")
    private String telefono;
}
