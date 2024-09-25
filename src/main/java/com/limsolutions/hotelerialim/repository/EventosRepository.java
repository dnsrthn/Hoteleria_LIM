package com.limsolutions.hotelerialim.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.limsolutions.hotelerialim.models.Eventos;
import java.util.List;
import java.sql.Date;


public interface EventosRepository extends JpaRepository <Eventos,Long>{

    List<Eventos> findByFecha(Date fecha);

}
