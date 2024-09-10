package com.limsolutions.hotelerialim.service;

import com.limsolutions.hotelerialim.models.Habitacion;
import java.util.List;

public interface IHabitacionService {

    // Definir un método de búsqueda con filtros
    List<Habitacion> buscarPorEstado(String estado);

    Habitacion buscarPorId(Long id_habitacion);

    public Habitacion guardarHabitacion(Habitacion habitacion);

}
