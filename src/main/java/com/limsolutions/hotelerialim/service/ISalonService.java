package com.limsolutions.hotelerialim.service;

import java.util.List;

import com.limsolutions.hotelerialim.models.Salon;

public interface ISalonService {
    
    public List<Salon> listarSalones();

    public Salon agregarSalones(Salon salon);

    public Salon buscarSalones(Long idSalon);

    public Salon editarSalones(Salon salon);

    
}
