package com.limsolutions.hotelerialim.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
<<<<<<< HEAD
=======
import jakarta.persistence.OneToMany;
>>>>>>> 5e9a27418b18d5d361a870c52f7cc13cd5f749ab
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;


@Entity
@Data
<<<<<<< HEAD
@Table(name = "Habitacion")
=======
@Table(name = "Habitaciones")
>>>>>>> 5e9a27418b18d5d361a870c52f7cc13cd5f749ab
public class Habitacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    @Column(name = "id_habitacion")
    private Long id_habitacion;

    @JoinColumn(name = "id_hotel", nullable = false)
    private Hotel id_hotel;
=======
    @Column(name = "id_Habitaciones")
    private Long id_Habitaciones;

    @JoinColumn(name = "id_hotel", nullable = false)
    private Hotel hotel;
>>>>>>> 5e9a27418b18d5d361a870c52f7cc13cd5f749ab

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "numero")
    private String numero;

    @Column(name = "estado")
    private String estado;

    @Column(name = "precio")
    private double precio;

    @ManyToOne
<<<<<<< HEAD
    @JoinColumn(name = "id_servicio",  nullable = false)
    private Servicio id_servicio;
=======
    @Column(name = "servicios", nullable = false)
    private Servicios servicios;
>>>>>>> 5e9a27418b18d5d361a870c52f7cc13cd5f749ab

}