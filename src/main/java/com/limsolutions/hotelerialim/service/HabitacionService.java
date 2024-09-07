package com.limsolutions.hotelerialim.service;

import com.limsolutions.hotelerialim.models.Habitacion;

import java.util.ArrayList;
import java.util.List;

public class HabitacionService implements IHabitacion {
    private List<Habitacion> habitaciones = new ArrayList<>();

    @Override
    public void registrarHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
    }

    @Override
    public void actualizarHabitacion(Habitacion habitacion) {
        for (int i = 0; i < habitaciones.size(); i++) {
            if (habitaciones.get(i).getId() == habitacion.getId()) {
                habitaciones.set(i, habitacion);
                return;
            }
        }
    }

    @Override
    public boolean verificarDisponibilidad(int idHabitacion, String fechaInicio, String fechaFin) {
        // controlador
        return true;
    }

    @Override
    public List<Habitacion> obtenerHabitacionesDisponibles() {
        return habitaciones;
    }
}
