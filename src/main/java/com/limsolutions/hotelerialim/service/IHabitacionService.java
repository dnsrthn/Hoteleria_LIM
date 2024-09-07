package com.limsolutions.hotelerialim.service;

import java.util.List;

import com.limsolutions.hotelerialim.models.Habitacion;

public interface IHabitacionService {

    public List<Habitacion> listarHabitaciones();

    public Habitacion buscarHabitacion(Long id_habitacion);

    public Habitacion guardarHabitacion(Habitacion habitacion);

    public void eliminarHabitacion(Habitacion habitacion);

}
