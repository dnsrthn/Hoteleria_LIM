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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
<<<<<<< HEAD
import lombok.AllArgsConstructor;
=======
>>>>>>> b899eaeede046912b10a831bcfcda97ef953f14a
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
<<<<<<< HEAD
@AllArgsConstructor 
@Entity
@Data
@Table(name = "Hotel")
=======
@Entity
@Data
@Table(name = "hotel")

>>>>>>> b899eaeede046912b10a831bcfcda97ef953f14a
public class Hotel implements Serializable{


    @Id
    @Column(name = "id_hotel")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
<<<<<<< HEAD
=======

>>>>>>> b899eaeede046912b10a831bcfcda97ef953f14a
    private Long id_hotel;


    @NotBlank(message = "El nombre es obligatorio")
    @Column(unique = true)
    private String nombre;

<<<<<<< HEAD
    @NotBlank(message = "La calificacion es obligatoria")
    private Long calificacion;

=======
    private Long calificacion;


>>>>>>> b899eaeede046912b10a831bcfcda97ef953f14a
    @NotBlank(message = "Ingrese una direccion")
    @Column(unique = true)
    private String direccion;

    @Email(message = "Debe ingresar un email valido")
    @Column(unique = true)
    private String correo;

<<<<<<< HEAD
    @NotBlank(message = "Ingrese el numero telefonico")
    private String telefono;

    @NotBlank(message = "Ingrese los ingresos generados")
=======
    private Long telefono;

>>>>>>> b899eaeede046912b10a831bcfcda97ef953f14a
    private double ingresos;


    @NotBlank(message = "Ingrese una fotografia del hotel")
    private String hotelPhoto;

    @NotBlank(message = "Ingrese el estado del hotel")
    private String estado;


    @OneToOne
    @JoinColumn(name = "id_pais", nullable = false )
<<<<<<< HEAD
    private Pais id_pais;
=======
    private Pais pais;
>>>>>>> b899eaeede046912b10a831bcfcda97ef953f14a


    @OneToOne
    @JoinColumn(name = "id_ciudad", nullable = false)
<<<<<<< HEAD
    private Ciudad id_ciudad;

    public Hotel(String estado){
        this.estado = estado;
    }
=======
    private Ciudad ciudad;
>>>>>>> b899eaeede046912b10a831bcfcda97ef953f14a

}

    
