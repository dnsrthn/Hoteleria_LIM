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
import com.limsolutions.hotelerialim.models.Eventos;
import com.limsolutions.hotelerialim.service.EventosService;

@RestController
@RequestMapping ("HoteleriaLIMSolutions/v1/Eventos")

public class EventosController  {

    @Autowired
    private EventosService eventosService;


    private static final Logger logger = LoggerFactory.getLogger(EventosController.class);

    @GetMapping("/listar_eventos")
    public List<Eventos> listarEventos(){
        var eventos =  eventosService.listarEventos();
        eventos.forEach((evento -> logger.info(evento.toString())));
        return eventos;
    }

    @PostMapping("/agregar_evento")
    public Eventos agregarEventos (@RequestBody Eventos eventos){
        logger.info("El evento a sido agregado" + eventos);
        return eventosService.guardarEvento(eventos);
    }

    @GetMapping("/buscar_evento/{id}")
    public ResponseEntity <Eventos> buscarEvento(@PathVariable Long id){
        Eventos eventos = eventosService.buscarEvento(id);
        if(eventos == null){
            logger.error("No se pudo encontrar el hotel indicado");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(eventos);
    }

        @PutMapping("/editar_evento/{id}")
        public ResponseEntity <Eventos> editarEvento (@PathVariable Long id, @RequestBody Eventos evento){
            Eventos  eventoEditar = eventosService.buscarEvento(id);

            if(eventoEditar == null){
                logger.error("No se pudo encontrar el evento indicado");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }else{
                eventoEditar.setNombre(evento.getNombre());
                eventoEditar.setTipo(evento.getTipo());
                eventoEditar.setCantidad(evento.getCantidad());
                eventoEditar.setFecha(evento.getFecha());
                eventoEditar.setHora(evento.getHora());
                eventoEditar.setContacto(evento.getContacto());
                eventoEditar.setEstado(evento.getEstado());
                eventoEditar.setOrganizador(evento.getOrganizador());
                eventoEditar.setOrganizador(evento.getOrganizador());
                eventoEditar.setId_hotel(evento.getId_hotel());
                eventoEditar.setId_salon(evento.getId_salon());
                eventosService.guardarEvento(eventoEditar);
                logger.info("Guardando registros modificados del evento");
            }
                return ResponseEntity.ok(eventoEditar);
        }

        @PutMapping("estado_evento/{id}")
        public ResponseEntity<Eventos> actualizarEstado(@PathVariable Long id,@RequestBody EstadoDto estado) {
            Eventos  eventoEditar = eventosService.buscarEvento(id);

            if(eventoEditar == null){
                logger.error("No se pudo encontrar el evento indicado");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            eventoEditar.setNombre(eventoEditar.getNombre());
            eventoEditar.setTipo(eventoEditar.getTipo());
            eventoEditar.setCantidad(eventoEditar.getCantidad());
            eventoEditar.setFecha(eventoEditar.getFecha());
            eventoEditar.setHora(eventoEditar.getHora());
            eventoEditar.setContacto(eventoEditar.getContacto());
            eventoEditar.setEstado(estado.getEstado());
            eventoEditar.setOrganizador(eventoEditar.getOrganizador());
            eventoEditar.setId_hotel(eventoEditar.getId_hotel());
            eventoEditar.setId_salon(eventoEditar.getId_salon());
            eventosService.guardarEvento(eventoEditar);
            logger.info("Guardando estado modificado del evento");
            return ResponseEntity.ok(eventoEditar);  
        }

}