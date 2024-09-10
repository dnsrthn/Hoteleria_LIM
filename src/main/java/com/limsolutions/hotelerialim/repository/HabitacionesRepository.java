package com.limsolutions.hotelerialim.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.limsolutions.hotelerialim.models.Habitacion;

public interface HabitacionesRepository extends JpaRepository<Habitacion, Long> {
    
}
