package com.limsolutions.hotelerialim.repository;

import com.limsolutions.hotelerialim.models.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion, Integer> {

    List<Habitacion> findByDisponibilidad();
}
