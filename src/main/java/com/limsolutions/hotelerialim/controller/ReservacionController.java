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
import com.limsolutions.hotelerialim.models.Cliente;
import com.limsolutions.hotelerialim.models.Reservacion;
import com.limsolutions.hotelerialim.service.ReservacionService;

@RestController
@RequestMapping ("HoteleriaLIMSolutions/v1/Reservacion")

public class ReservacionController  {

    @Autowired
    private ReservacionService reservacionService;


    private static final Logger logger = LoggerFactory.getLogger(ReservacionController.class);

    @GetMapping("/listar_reservaciones")
    public List<Reservacion> listarReservaciones(){
        var reservacion2 =  reservacionService.listarReservaciones();
        reservacion2.forEach((reservacion -> logger.info(reservacion.toString())));
        return reservacion2;
    }

    @PostMapping("/agregar_reservacion")
    public Reservacion agregarReservacion (@RequestBody Reservacion reservacion){
        logger.info("Rservacion agregada" + reservacion);
        return reservacionService.registrarReservacion(reservacion);
    }

    @GetMapping("/buscar_reservacion/{id}")
    public ResponseEntity <Reservacion> buscarCliente(@PathVariable Long id){
        Reservacion reservacion = reservacionService.buscarReservacion(id);
        if(reservacion == null){
            logger.error("No se pudo encontrar la reservacion indicada");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(reservacion);
    }

        @PutMapping("/editar_reservacion/{id}")
        public ResponseEntity <Reservacion> editarReservacion (@PathVariable Long id, @RequestBody Reservacion reservacion){
            Reservacion reservacionEditar = reservacionService.buscarReservacion(id);

             if(reservacionEditar == null){
                logger.error("No se pudo encontrar la reservacion indicada");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }else{
                reservacionEditar.setDias(reservacion.getDias());
                reservacionEditar.setEstado(reservacion.getEstado());
                reservacionEditar.setId_hotel(reservacion.getId_hotel());
                reservacionEditar.setId_habitacion(reservacion.getId_habitacion());
                reservacionEditar.setId_cliente(reservacion.getId_cliente());
                reservacionService.registrarReservacion(reservacion);
                    logger.info("Guardando reservacion modificada");
                }
                    return ResponseEntity.ok(reservacionEditar);
        }

        @PutMapping("estado_reservacion/{id}")
        public ResponseEntity<Reservacion> actualizarEstado(@PathVariable Long id,@RequestBody EstadoDto estado) {
            Reservacion reservacionEditar = reservacionService.buscarReservacion(id);

            if(reservacionEditar == null){
               logger.error("No se pudo encontrar la reservacion indicada");
               return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }else{
                reservacionEditar.setDias(reservacionEditar.getDias());
                reservacionEditar.setEstado(estado.getEstado());
                reservacionEditar.setId_hotel(reservacionEditar.getId_hotel());
                reservacionEditar.setId_habitacion(reservacionEditar.getId_habitacion());
                reservacionEditar.setId_cliente(reservacionEditar.getId_cliente());
                reservacionService.registrarReservacion(reservacionEditar);
                    logger.info("Guardando estado de reservacion modificada");
                }
                    return ResponseEntity.ok(reservacionEditar);
        }

}
