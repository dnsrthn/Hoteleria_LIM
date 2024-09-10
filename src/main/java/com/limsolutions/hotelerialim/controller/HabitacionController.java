package com.limsolutions.hotelerialim.controller;

import com.limsolutions.hotelerialim.models.Habitacion;
import com.limsolutions.hotelerialim.service.HabitacionService;

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
    private HabitacionService habitacionService;

    // 1. Buscar habitaciones por estado ("DISPONIBLE" o "NO DISPONIBLE")
    @GetMapping("/listarestado")
    public List<Habitacion> listarHabitacionesPorEstado(@RequestParam String estado) { 
        // Devuelve una lista de objetos Habitacion, (El metodo espera un parametro llamado estado se usara para filtrar las habitaiones por estado)
        logger.info("Listando habitaciones con estado: {}", estado);
        // Registra un mensaje informativo indica que se esta listando con el estado.
        List<Habitacion> habitaciones = habitacionService.buscarPorEstado(estado);
        // Llama al service para buscar habitaciones que coincidan con el estado proporcionado
        logger.info("Se encontraron {} habitaciones con estado: {}", habitaciones.size(), estado);
        // egistra otro mensaje informativo indicando cuántas habitaciones fueron encontradas con el estado especificado.
        return habitaciones;
        // Devuelve la lista de habitaciones encontradas al cliente
    }

    // 2. Reservar una habitación (cambia el estado a "reservada")
    @PostMapping("/{id}/reservar")
    public ResponseEntity<String> reservarHabitacion(@PathVariable Long id_habitacion) {
        // Llama al método buscarPorId del servicio habitacionService para recuperar la habitación correspondiente al ID proporcionado. El resultado se almacena en la variable habitacion.
        Habitacion habitacion = habitacionService.buscarPorId(id_habitacion);
        // Llama al método buscarPorId del servicio habitacionService para recuperar la habitación correspondiente al ID proporcionado. El resultado se almacena en la variable habitacion.
        if (habitacion == null || !habitacion.getEstado().equals("DISPONIBLE")) {
            // Verifica si la habitación es null (lo que significa que no se encontró una habitación con el ID proporcionado) o si el estado de la habitación no es "DISPONIBLE". Si alguna de estas condiciones es verdadera, significa que la habitación no puede ser reservada.
            return ResponseEntity.badRequest().body("Habitación no disponible para reservar.");
            // Si la habitación no está disponible, devuelve una respuesta HTTP con un código de estado 400 (Bad Request) y un mensaje de error indicando que la habitación no puede ser reservada.
        }

        habitacion.setEstado("RESERVADA");
        // Cambia el estado de la habitación a "RESERVADA" para indicar que la habitación está ahora reservada.
        habitacionService.guardarHabitacion(habitacion);
        // Llama al método guardarHabitacion del servicio habitacionService para guardar los cambios en la base de datos.

        return ResponseEntity.ok("Habitación reservada con éxito.");
        // Devuelve una respuesta HTTP con un código de estado 200 (OK) y un mensaje indicando que la habitación ha sido reservada con éxito.
    }
}