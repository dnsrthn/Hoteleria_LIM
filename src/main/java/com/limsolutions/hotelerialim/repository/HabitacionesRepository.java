package com.limsolutions.hotelerialim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.limsolutions.hotelerialim.models.Habitacion;
import java.util.List;

public interface HabitacionesRepository extends JpaRepository<Habitacion, Long> {
    
    // Método para obtener todas las habitaciones, sin filtros
    List<Habitacion> findAll();
}
