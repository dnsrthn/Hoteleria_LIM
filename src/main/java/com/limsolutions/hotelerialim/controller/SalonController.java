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
import com.limsolutions.hotelerialim.models.Salon;
import com.limsolutions.hotelerialim.service.SalonService;




@RestController
@RequestMapping ("HoteleriaLIMSolutions/v1/Salon")

public class SalonController {
    
    @Autowired
    private SalonService salonService;

    public static final Logger logger = LoggerFactory.getLogger(SalonController.class);

    @GetMapping("/listar_salones")
    public List<Salon> listarSalones(){
        var salon = salonService.listarSalones();
        salon.forEach((salones -> logger.info(salones.toString())));
        return salon;        
    }

    @PostMapping("/agregar_salones")
    public Salon agregarSalon (@RequestBody Salon salon){
        logger.info("El salon ya ha sido agregado" + salon);
        return salonService.agregarSalones(salon);
    }

    @GetMapping("/buscar_salon/{id}")
    public ResponseEntity <Salon> buscarSalones(@PathVariable Long id){
        Salon salon = salonService.buscarSalones(id);
        if(salon == null){
            logger.error("No se encontro el salon indicado");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(salon);
    }

    @PutMapping("/editar_salon/{id}")
    public ResponseEntity <Salon> editarSalones (@PathVariable Long id, @RequestBody Salon salon){
        Salon SalonEditar = salonService.buscarSalones(id);
        if(SalonEditar == null){
            logger.error("No se pudo actualizar la informacion de el salon");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            SalonEditar.setNombre(salon.getNombre());
            SalonEditar.setCapacidad(salon.getCapacidad());
            SalonEditar.setEstado(salon.getEstado());
            SalonEditar.setDescripcion(salon.getDescripcion());
            SalonEditar.setId_hotel(salon.getId_hotel());
            SalonEditar.setId_servicio(salon.getId_servicio());
            salonService.agregarSalones(SalonEditar);
            logger.info("Guardando los registros modificados"); 
        }
        return ResponseEntity.ok(SalonEditar);
    }
    
    @PutMapping("estado_servicio/{id}")
        public ResponseEntity<Salon> actualizarEstado(@PathVariable Long id,@RequestBody EstadoDto estado) {
            Salon SalonEditar = salonService.buscarSalones(id);
            if(SalonEditar == null){
                logger.error("No se pudo actualizar la informacion de el salon");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            SalonEditar.setNombre(SalonEditar.getNombre());
            SalonEditar.setCapacidad(SalonEditar.getCapacidad());
            SalonEditar.setEstado(estado.getEstado());
            SalonEditar.setDescripcion(SalonEditar.getDescripcion());
            SalonEditar.setId_hotel(SalonEditar.getId_hotel());
            SalonEditar.setId_servicio(SalonEditar.getId_servicio());
            salonService.agregarSalones(SalonEditar);
            logger.info("Guardando estado modificado de la habitacion");
            return ResponseEntity.ok(SalonEditar);  
        }


}


    
    

