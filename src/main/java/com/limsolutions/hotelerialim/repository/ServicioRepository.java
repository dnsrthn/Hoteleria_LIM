package com.limsolutions.hotelerialim.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.limsolutions.hotelerialim.models.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio, Long>{

    List<Servicio> findById_Hotel(Long id_hotel);

}
