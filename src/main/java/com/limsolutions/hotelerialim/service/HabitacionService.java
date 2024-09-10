package com.limsolutions.hotelerialim.service;

import com.limsolutions.hotelerialim.models.Habitacion;
import com.limsolutions.hotelerialim.repository.HabitacionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HabitacionService implements IHabitacionService {

    @Autowired
    private HabitacionesRepository habitacionesRepository;

    @Override
     // Buscar todas las habitaciones por estado
    public List<Habitacion> buscarPorEstado(String estado) {
        return habitacionesRepository.findByEstado(estado);
    }
    

}
