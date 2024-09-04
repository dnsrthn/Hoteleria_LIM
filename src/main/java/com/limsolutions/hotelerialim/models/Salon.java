package com.limsolutions.hotelerialim.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data
@Table(name = "salon")
public class Salon implements Serializable {

    private static final long serialVersionUID = 1L; // versión de serialización

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_salon")
    private Long idSalon;

    @Column(name = "id_hotel", nullable = false)
    private Long idHotel; // id del hotel como clave foránea

    @Column(name = "id_servicio", nullable = false)
    private Long idServicio; // id del servicio como clave foránea

    @NotBlank(message = "El nombre no puede estar en blanco")
    @Column(name = "nombre")
    private String nombre;

    @NotNull(message = "La capacidad no puede ser nula")
    @Column(name = "capacidad", nullable = false)
    private Integer capacidad;

    @Column(name = "descripcion")
    private String descripcion;

}