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
<<<<<<< HEAD
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
=======
<<<<<<< HEAD
=======
import jakarta.persistence.OneToMany;
>>>>>>> 5e9a27418b18d5d361a870c52f7cc13cd5f749ab
import jakarta.persistence.Table;
import java.io.Serializable;
>>>>>>> b899eaeede046912b10a831bcfcda97ef953f14a
import lombok.Data;


@Entity
@Data
<<<<<<< HEAD
@Table(name = "Habitacion")
=======
<<<<<<< HEAD
@Table(name = "Habitacion")
=======
@Table(name = "Habitaciones")
>>>>>>> 5e9a27418b18d5d361a870c52f7cc13cd5f749ab
>>>>>>> b899eaeede046912b10a831bcfcda97ef953f14a
public class Habitacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> b899eaeede046912b10a831bcfcda97ef953f14a
    @Column(name = "id_habitacion")
    private Long id_habitacion;

    @JoinColumn(name = "id_hotel", nullable = false)
    private Hotel id_hotel;
<<<<<<< HEAD

    @Column(name = "tipo")
    @NotBlank(message = "El tipo de habitacion es obligatorio")
    private String tipo;

    @Column(name = "numero")
    @NotBlank(message = "El numero de habitacion es obligatorio")
    private String numero;

    @Column(name = "estado")
    @NotBlank(message = "El estado es obligatorio")
    private String estado;

    @Column(name = "precio")
    @NotBlank(message = "El precio es obligatorio")
    private double precio;

    @ManyToOne
    @JoinColumn(name = "id_servicio",  nullable = false)
    private Servicio id_servicio;
=======
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
>>>>>>> b899eaeede046912b10a831bcfcda97ef953f14a

}