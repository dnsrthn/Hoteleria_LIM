package com.limsolutions.hotelerialim.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.limsolutions.hotelerialim.models.Salon;
import com.limsolutions.hotelerialim.repository.SalonRepository;

@Service
public class SalonService implements ISalonService{

    @Autowired
    private SalonRepository salonRepository;

    @Override
    public List<Salon> listarSalones() {
        return salonRepository.findAll();
    }

    @Override
    public Salon agregarSalones(Salon salon) {
        return salonRepository.save(salon);
    }

     @Override
    public Salon buscarSalones(Long idSalon) {
        Optional<Salon> salon = salonRepository.findById(idSalon);
        return salon.orElse(null);
    }

    
    @Override
    public Salon editarSalones(Salon salon) {
        if (salonRepository.existsById(salon.getId())) {
            return salonRepository.save(salon);
        } else {
            return null; 
       }
    }
}