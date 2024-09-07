package com.limsolutions.hotelerialim.controller;

import com.limsolutions.hotelerialim.models.Habitacion;
import com.limsolutions.hotelerialim.service.IHabitacionService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("HoteleriaLIMSolutions/v1/habitaciones")
public class HabitacionController {
    private static final Logger logger = LoggerFactory.getLogger(HabitacionController.class);

    @Autowired
    private IHabitacionService IHabitacionService;

    @GetMapping("/listar")
    public List<Habitacion> obtenerHabitacion() {
        var habitacion2 = IHabitacionService.listarHabitaciones();
        habitacion2.forEach(habitacion -> logger.info(habitacion.toString()));
        return habitacion2;
    }

    @PostMapping("/agregar")
    public Habitacion agregarHabitacion(@RequestBody Habitacion habitacion) {
        logger.info("Habitacion agregada" + habitacion);
        return IHabitacionService.guardarHabitacion(habitacion);
    }

    @GetMapping("/habitaciones/{id_habitacion}")
    public ResponseEntity <Habitacion> buscarHabitacion(@PathVariable Long id_habitacion){
        Habitacion habitacion = IHabitacionService.buscarHabitacion(id_habitacion);

        return ResponseEntity.ok(habitacion);
    }

    
    




}




