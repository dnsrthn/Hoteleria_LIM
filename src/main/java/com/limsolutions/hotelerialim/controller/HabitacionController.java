package com.limsolutions.hotelerialim.controller;

import com.limsolutions.hotelerialim.models.Habitacion;
import com.limsolutions.hotelerialim.service.IHabitacionService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    
}
