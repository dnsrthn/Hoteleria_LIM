package com.limsolutions.hotelerialim.models;

<<<<<<< HEAD
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

=======
>>>>>>> b899eaeede046912b10a831bcfcda97ef953f14a
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
<<<<<<< HEAD
import lombok.Data;

@Entity
@Data
@Table(name = "Eventos")
=======

import java.io.Serializable;

import java.sql.Date;
import java.sql.Time;
import lombok.Data;
import lombok.NoArgsConstructor;

// @NoArgsConstructor

@Entity
@Data
@Table(name = "eventos")
>>>>>>> b899eaeede046912b10a831bcfcda97ef953f14a
public class Eventos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_eventos")
<<<<<<< HEAD
    private Long id_eventos;
=======
    private Long id_Eventos;
>>>>>>> b899eaeede046912b10a831bcfcda97ef953f14a

    @ManyToOne
    @JoinColumn(name = "id_hotel", nullable = false)
    private Hotel id_hotel;

    @ManyToOne 
    @JoinColumn(name = "id_salon", nullable = false)
    private Salon id_salon;

    @NotBlank(message = "El nombre no puede estar en blanco")
    @Column(name = "nombre")
    private String nombre;

<<<<<<< HEAD
    @NotBlank(message = "El tipo de evento no puede estar en blanco")
=======
    @NotBlank(message = "El tipo no puede estar en blanco")
>>>>>>> b899eaeede046912b10a831bcfcda97ef953f14a
    @Column(name = "tipo")
    private String tipo;

    @Column(name = "cantidad", nullable = false)
<<<<<<< HEAD
    private Long cantidad;
=======
    private int cantidad;
>>>>>>> b899eaeede046912b10a831bcfcda97ef953f14a

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Column(name = "hora", nullable = false)
    private Time hora;

    @NotBlank(message = "El contacto no puede estar en blanco")
    @Column(name = "contacto")
    private String contacto;

    @NotBlank(message = "El estado no puede estar en blanco")
    @Column(name = "estado")
    private String estado;

    @NotBlank(message = "El organizador no puede estar en blanco")
    @Column(name = "organizador")
    private String organizador;


}