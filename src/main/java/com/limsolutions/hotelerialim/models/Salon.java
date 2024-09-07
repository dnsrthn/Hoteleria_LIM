package com.limsolutions.hotelerialim.models;


<<<<<<< HEAD
import java.io.Serializable;

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
@Table(name = "Salon")
=======
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data
@Table(name = "salon")
>>>>>>> b899eaeede046912b10a831bcfcda97ef953f14a
public class Salon implements Serializable {

    private static final long serialVersionUID = 1L; // versión de serialización

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_salon")
    private Long id_salon;

    @ManyToOne
    @JoinColumn(name = "id_hotel", nullable = false)
    private Hotel id_hotel; // id del hotel como clave foránea   

    @ManyToOne
    @JoinColumn(name = "id_servicio", nullable = false)
    private Servicio id_servicio; // id del servicio como clave foránea

    @NotBlank(message = "El nombre no puede estar en blanco")
    @Column(name = "nombre")
    private String nombre;

<<<<<<< HEAD
    @NotBlank(message = "La capacidad no puede ser nula")
    @Column(name = "capacidad", nullable = false)
    private Long capacidad;
=======
    @NotNull(message = "La capacidad no puede ser nula")
    @Column(name = "capacidad", nullable = false)
    private Integer capacidad;
>>>>>>> b899eaeede046912b10a831bcfcda97ef953f14a

    @Column(name = "descripcion")
    private String descripcion;

}