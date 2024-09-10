package com.limsolutions.hotelerialim.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.limsolutions.hotelerialim.models.Servicio;
import com.limsolutions.hotelerialim.repository.ServicioRepository;

@Service
public class ServicioService implements IServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    @Override
    public List<Servicio> listarServicios(){
        return servicioRepository.findAll();
    }

    @Override
    public Servicio buscarServicio (Long id_servicio){
        Servicio servicio = servicioRepository.findById(id_servicio).orElse(null);
        return servicio;
    }

    @Override
    public Servicio guardarServicio (Servicio servicio){
        return servicioRepository.save(servicio);
    }

    @Override 
    public void eliminarServicio (Servicio servicio){
        servicioRepository.delete(servicio);
    }

    @Override
    public List<Servicio> listarServiciosPorHotel(Long id_hotel) {
        return servicioRepository.findById_Hotel(id_hotel);

    }




}
