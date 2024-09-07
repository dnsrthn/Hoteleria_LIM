package com.limsolutions.hotelerialim.service;

import com.limsolutions.hotelerialim.models.Habitacion;
import java.util.List;

public interface IHabitacionService {

    public List<Habitacion> listarHabitaciones();

    public Habitacion buscarHabitacion(Long id_habitacion);

    public Habitacion guardarHabitacion(Habitacion habitacion);

}
