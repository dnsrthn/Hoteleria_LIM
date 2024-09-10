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
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name = "Servicio")
public class Servicio implements Serializable{
    @Id
    @Column(name = "id_servicio", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_servicio;

    @OneToOne
    @JoinColumn(name = "id_hotel", nullable = false)
    private Hotel id_hotel;
    
    @NotBlank(message = "Necesitas llenar el nombre")
    private String nombre;


}
