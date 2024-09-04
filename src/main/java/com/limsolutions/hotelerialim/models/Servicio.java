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

@Entity
@Table(name = "servicio")
public class Servicio implements Serializable{
    @Id
    @Column(name = "id_servcio", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_servicio;

    @OneToOne
    @JoinColumn(name = "id_hotel", nullable = false)
    private Hotel hotel;

    private String nombre;


}
