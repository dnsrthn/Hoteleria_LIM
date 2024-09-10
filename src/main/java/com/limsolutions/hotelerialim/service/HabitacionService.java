package com.limsolutions.hotelerialim.service;

import com.limsolutions.hotelerialim.models.Habitacion;
import com.limsolutions.hotelerialim.repository.HabitacionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HabitacionService implements IHabitacionService {

    @Autowired
    private HabitacionesRepository habitacionesRepository;// Permite a la clase acceder a métodos para interactuar con la base de datos.

    // Buscar todas las habitaciones por estado
    @Override
    public List<Habitacion> buscarPorEstado(String estado) {// Este método usa el repositorio para encontrar habitaciones que coincidan con el estado proporcionado.
        return habitacionesRepository.findByEstado(estado);// Llama al método del repositorio para realizar la búsqueda.
    }

    // Buscar una habitación por su ID
    @Override
    public Habitacion buscarPorId(Long id_habitacion) {// Implementa el método buscarPorId de la interfaz IHabitacionService. Busca una habitación por su ID.
        return habitacionesRepository.findById(id_habitacion).orElse(null);// Intenta encontrar la habitación por su ID y devuelve null si no se encuentra.
    }

    // Guardar o actualizar una habitación
    @Override
    public Habitacion guardarHabitacion(Habitacion habitacion) {// Guarda o actualiza una habitación en la base de datos.
        return habitacionesRepository.save(habitacion);// guarda la habitación en la base de datos. Si la habitación ya existe, se actualiza; si no, se crea una nueva.
    }
}
