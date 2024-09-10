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

    @Override
    public List<Habitacion> listarHabitaciones(){

        return habitacionesRepository.findAll();
    }    
}
