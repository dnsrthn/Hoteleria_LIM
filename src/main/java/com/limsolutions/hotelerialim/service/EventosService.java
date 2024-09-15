package com.limsolutions.hotelerialim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.limsolutions.hotelerialim.models.Eventos;
import com.limsolutions.hotelerialim.repository.EventosRepository;

@Service
public class EventosService implements IEventosService{
    @Autowired
    private EventosRepository empEven; // sirve para comunicar el servicio y el bean
    
    @Override
    public List<Eventos> listarEventos() {
        return empEven.findAll();
    }

    @Override
    public Eventos buscarEvento (Long id) {
        Eventos emp = empEven.findById(id).orElse(null);
        return emp;
    }

    @Override
    public Eventos guardarEvento(Eventos eventos) {
        return empEven.save(eventos);
    }

}  