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

import com.limsolutions.hotelerialim.models.Salon;
import com.limsolutions.hotelerialim.service.SalonService;




@RestController
@RequestMapping ("HoteleriaLIMSolutions/v1/Salon")

public class SalonController {
    
    @Autowired
    private SalonService salonService;

    public static final Logger logger = LoggerFactory.getLogger(SalonController.class);


    //http://localhost:8081/HoteleriaLIMSolutions/v1/Salon
    @GetMapping("/listar")
    public List<Salon> obtenerSalones(){
        var salon = salonService.listarSalones();
        salon.forEach((salones -> logger.info(salones.toString())));
        return salon;        
    }

    //http://localhost:8081/HoteleriaLIMSolutions/v1/Salon
    @PostMapping("/Agregar")
    public Salon agregarSalones (@RequestBody Salon salon){
        logger.info("El salon ya ha sido agregado" + salon);
        return salonService.agregarSalones(salon);
    }

    //http://localhost:8081/HoteleriaLIMSolutions/v1/Salon
    @GetMapping("/buscar/{id}")
    public ResponseEntity <Salon> buscarSalones(@PathVariable Long id){
        Salon salon = salonService.buscarSalones(id);
        if(salon == null){
            logger.error("No se encontro el salon indicado");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
        }
        return ResponseEntity.ok(salon);
    }

     //http://localhost:8081/HoteleriaLIMSolutions/v1/Salon
    @PutMapping("/editar/{id}")
    public ResponseEntity <Salon> editarSalones (@PathVariable Long id, @RequestBody Salon salon){
        Salon SalonEditar = salonService.buscarSalones(id);
        if(SalonEditar == null){
            logger.error("No se pudo actualizar la informacion de el salon");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            SalonEditar.setId_hotel(salon.getId_hotel());
            SalonEditar.setId_servicio(salon.getId_servicio());
            SalonEditar.setNombre(salon.getNombre());
            SalonEditar.setCapacidad(salon.getCapacidad());
            SalonEditar.setEstado(salon.getEstado());
            SalonEditar.setDescripcion(salon.getDescripcion());
            salonService.agregarSalones(SalonEditar);
            logger.info("Guardando los registros modificados"); 
        }
        return ResponseEntity.ok(SalonEditar);
    }
    
    @PatchMapping("cambiar-estado/{id}")
    public ResponseEntity<Salon> cambiarEstado(@PathVariable Long id,@RequestBody Salon salon) {
        Salon SalonEditar = salonService.buscarSalones(id);

        if(SalonEditar == null){
            logger.error("No se pudo actualizar la informacion de el salon");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        SalonEditar.setEstado(salon.getEstado());
        salonService.agregarSalones(SalonEditar);
        return ResponseEntity.ok(SalonEditar);
    }


}


    
    

