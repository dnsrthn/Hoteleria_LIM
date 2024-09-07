package com.limsolutions.hotelerialim.service;

import com.limsolutions.hotelerialim.models.Habitacion;
import java.util.List;

public interface IHabitacion {
    void registrarHabitacion(Habitacion habitacion);
    void actualizarHabitacion(Habitacion habitacion);
    boolean verificarDisponibilidad(int idHabitacion, String fechaInicio, String fechaFin);
    List<Habitacion> obtenerHabitacionesDisponibles();
}
