package com.limsolutions.hotelerialim.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.limsolutions.hotelerialim.DTOS.EstadoDto;
import com.limsolutions.hotelerialim.models.Habitacion;
import com.limsolutions.hotelerialim.service.HabitacionService;

@RestController
@RequestMapping("HoteleriaLIMSolutions/v1/habitacion")
public class HabitacionController {
    private static final Logger logger = LoggerFactory.getLogger(HabitacionController.class);

    @Autowired
    private HabitacionService habitacionService;

    @GetMapping("/listar_habitaciones")
    public List<Habitacion> obtenerHabitacion() {
        var habitacion2 = habitacionService.listarHabitaciones();
        habitacion2.forEach(habitacion -> logger.info(habitacion.toString()));
        return habitacion2;
    }

    @PostMapping("/registrar_habitacion")
    public Habitacion agregarHabitacion(@RequestBody Habitacion habitacion) {
        logger.info("Habitacion agregada" + habitacion);
        return habitacionService.guardarHabitacion(habitacion);
    }

    @GetMapping("/buscar_habitacion/{id_habitacion}")
    public ResponseEntity<Habitacion> buscarHabitacion(@PathVariable Long id_habitacion) {
        Habitacion habitacion = habitacionService.buscarHabitacion(id_habitacion);
        return ResponseEntity.ok(habitacion);
    }

    @PutMapping("/editar_habitacion/{id_habitacion}")
    public ResponseEntity<Habitacion> editarHabitacion(@PathVariable Long id_habitacion,
            @RequestBody Habitacion habitacionRecibido) {
        Habitacion habitacion = habitacionService.buscarHabitacion(id_habitacion);
        if(habitacion == null){
            logger.error("No se pudo encontrar la habitacion indicada");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        habitacion.setTipo(habitacionRecibido.getTipo());
        habitacion.setPrecio(habitacionRecibido.getPrecio());
        habitacion.setNumero(habitacionRecibido.getNumero());
        habitacion.setEstado(habitacionRecibido.getEstado());
        habitacion.setId_hotel(habitacionRecibido.getId_hotel());
        habitacion.setId_servicio(habitacionRecibido.getId_servicio());
        habitacionService.guardarHabitacion(habitacion);
        return ResponseEntity.ok(habitacion);
    }

    @PutMapping("estado_habitacion/{id}")
        public ResponseEntity<Habitacion> actualizarEstado(@PathVariable Long id,@RequestBody EstadoDto estado) {
            Habitacion  habitacionEditar = habitacionService.buscarHabitacion(id);

            if(habitacionEditar == null){
                logger.error("No se pudo encontrar la habitacion indicada");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            habitacionEditar.setTipo(habitacionEditar.getTipo());
            habitacionEditar.setPrecio(habitacionEditar.getPrecio());
            habitacionEditar.setNumero(habitacionEditar.getNumero());
            habitacionEditar.setEstado(estado.getEstado());
            habitacionEditar.setId_hotel(habitacionEditar.getId_hotel());
            habitacionEditar.setId_servicio(habitacionEditar.getId_servicio());
            habitacionService.guardarHabitacion(habitacionEditar);
            logger.info("Guardando estado modificado de la habitacion");
            return ResponseEntity.ok(habitacionEditar);  
        }

}