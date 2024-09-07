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
<<<<<<< HEAD
import jakarta.validation.constraints.NotBlank;
=======
>>>>>>> b899eaeede046912b10a831bcfcda97ef953f14a
import lombok.Data;

@Entity
@Data
<<<<<<< HEAD
@Table(name = "Servicio")
public class Servicio implements Serializable{
    @Id
    @Column(name = "id_servicio", nullable = false)
=======
@Table(name = "servicio")
public class Servicio implements Serializable{
    @Id
    @Column(name = "id_servcio", nullable = false)
>>>>>>> b899eaeede046912b10a831bcfcda97ef953f14a
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_servicio;

    @OneToOne
    @JoinColumn(name = "id_hotel", nullable = false)
    private Hotel id_hotel;
<<<<<<< HEAD
    
    @NotBlank(message = "Necesitas llenar el nombre")
=======

>>>>>>> b899eaeede046912b10a831bcfcda97ef953f14a
    private String nombre;


}
