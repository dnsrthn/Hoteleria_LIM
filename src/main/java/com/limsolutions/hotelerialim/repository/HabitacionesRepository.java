package com.limsolutions.hotelerialim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.limsolutions.hotelerialim.models.Habitacion;
import java.util.List;

public interface HabitacionesRepository extends JpaRepository<Habitacion, Long> {

    // Buscar habitaciones por estado ("DISPONIBLE" o "NO DISPONIBLE")
    List<Habitacion> findByEstado(String estado);
}
