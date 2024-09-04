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

@Entity
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


    public Eventos() {
    }

    public Long getId_Eventos() {
        return id_Eventos;
    }

    public void set_IdEventos(Long id_Eventos) {
        this.id_Eventos = id_Eventos;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getOrganizador() {
        return organizador;
    }

    public void setOrganizador(String organizador) {
        this.organizador = organizador;
    }
}