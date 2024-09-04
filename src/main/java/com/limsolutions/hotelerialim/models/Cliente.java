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
    private Long idCLiente;

    @NotBlank
    private String nombreCompleto;

    @Email(message="ingresa un email valido")
    @NotBlank
    @Column(unique = true)
    private String correo; 
    
    @NotBlank
    private String telefono;
}
