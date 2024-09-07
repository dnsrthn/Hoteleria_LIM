package com.limsolutions.hotelerialim.models;

import java.io.Serializable;

<<<<<<< HEAD
=======

>>>>>>> b899eaeede046912b10a831bcfcda97ef953f14a
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
<<<<<<< HEAD
import jakarta.validation.constraints.NotBlank;
=======
>>>>>>> b899eaeede046912b10a831bcfcda97ef953f14a
import lombok.Data;

@Entity
@Data
@Table(name = "Reservacion")
public class Reservacion implements Serializable{
    @Id
    @Column(name = "id_reservacion", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_reservacion;

    @OneToOne
    @JoinColumn(name = "id_hotel", nullable = false)
    private Hotel id_hotel;

    @OneToOne
    @JoinColumn(name = "id_habitacion", nullable = false)
    private Habitacion id_habitacion;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente id_cliente; 

    @Column(unique = false)
<<<<<<< HEAD
    @NotBlank(message ="envio de dias obligatorio")
    private Long dias;
    
    @NotBlank(message ="envio de estado obligatorio")
=======
    private int dias;

>>>>>>> b899eaeede046912b10a831bcfcda97ef953f14a
    private String estado;
}
