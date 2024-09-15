package com.limsolutions.hotelerialim.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.limsolutions.hotelerialim.models.Eventos;
import com.limsolutions.hotelerialim.service.EventosService;

// import com.limsolutions.hotelerialim.models.Salon;

@RestController
@RequestMapping ("HoteleriaLIMSolutions/v1/Eventos")

public class EventosController  {

    @Autowired
    private EventosService eventosService;


    private static final Logger logger = LoggerFactory.getLogger(EventosController.class);

    //http://localhost:8081/hr-Evento/empleadoA/listar
    @GetMapping("/listar")
    public List<Eventos> obteEmpleados(){
        var eventos =  eventosService.listarEventos();
        eventos.forEach((evento -> logger.info(evento.toString())));
        return eventos;
    }

    //http://localhost:8081/hr-Evento/Eventos/Agregar
    @PostMapping("/Agregar")
    public Eventos agregarEventos (@RequestBody Eventos eventos){
        logger.info("El evento a sido agregado" + eventos);
        return eventosService.guardarEvento(eventos);
    }

    //http://localhost:8081/hr-Evento/buscar/1
    @GetMapping("/buscar/{id}")
    public ResponseEntity <Eventos> buscarEvento(@PathVariable Long id){
        Eventos eventos = eventosService.buscarEvento(id);
        if(eventos == null){
            logger.error("No se pudo encontrar el hotel indicado");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(eventos);
    }

        @PutMapping("/editar-hotel/{idHotel}")
        public ResponseEntity <Eventos> editarHotel (@PathVariable Long id, @RequestBody Eventos evento){
            Eventos  EventoEditar = eventosService.buscarEvento(id);
            if(EventoEditar == null){
                logger.error("No se pudo encontrar el evento indicado");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }else{
                EventoEditar.setId_hotel(evento.getId_hotel());
                EventoEditar.setId_salon(evento.getId_salon());
                EventoEditar.setNombre(evento.getNombre());
                EventoEditar.setTipo(evento.getTipo());
                EventoEditar.setCantidad(evento.getCantidad());
                EventoEditar.setFecha(evento.getFecha());
                EventoEditar.setHora(evento.getHora());
                EventoEditar.setContacto(evento.getContacto());
                EventoEditar.setEstado(evento.getEstado());
                EventoEditar.setOrganizador(evento.getOrganizador());
                eventosService.guardarEvento(EventoEditar);
                logger.info("Guardando registros modificados del evento");
            }
                return ResponseEntity.ok(EventoEditar);
        }

        @PatchMapping("cambiar-estado/{id}")
    public ResponseEntity<Eventos> actualizarEstado(@PathVariable Long id,@RequestBody Eventos evento) {
        Eventos  EventoEditar = eventosService.buscarEvento(id);
        if(EventoEditar == null){
            logger.error("No se pudo encontrar el evento indicado");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        EventoEditar.setEstado(evento.getEstado());
        eventosService.guardarEvento(EventoEditar);
        return ResponseEntity.ok(EventoEditar);
    }

}