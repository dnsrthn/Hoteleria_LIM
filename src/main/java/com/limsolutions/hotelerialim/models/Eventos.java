package com.limsolutions.hotelerialim.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor

@Entity
@Data
@Table(name = "eventos")
public class Eventos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_eventos")
    private Long id_Eventos;

    @OneToMany
    @JoinColumn(name = "id_hotel", nullable = false)
    private Hotel hotel;

    @OneToMany
    @JoinColumn(name = "id_salon", nullable = false)
    private Salon salon;

    @NotBlank(message = "El nombre no puede estar en blanco")
    @Column(name = "nombre")
    private String nombre;

    @NotBlank(message = "El tipo no puede estar en blanco")
    @Column(name = "tipo")
    private String tipo;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "hora", nullable = false)
    private LocalTime hora;

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