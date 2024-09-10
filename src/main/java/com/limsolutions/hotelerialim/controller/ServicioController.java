package com.limsolutions.hotelerialim.controller;

//  ;)
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.limsolutions.hotelerialim.models.Servicio;
import com.limsolutions.hotelerialim.service.ServicioService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("HoteleriaLIMSolutions/v1/Servicio")

public class ServicioController {

    private static final Logger logger = LoggerFactory.getLogger(ServicioController.class);

    @Autowired

    private ServicioService servicioService;

    @GetMapping("/listar")
    public List<Servicio> listaServicios(){
        var servic = servicioService.listarServicios();
        servic.forEach(servicio -> logger.info(servicio.toString()));
        return servic;
    }

    @PostMapping("/agregar")

    public Servicio agregarServicio(@RequestBody Servicio servicio){
        logger.info("El servicio ha sido agregado");
        return servicioService.guardarServicio(servicio);
    }

    @GetMapping("/buscar/{id}")

    public ResponseEntity <Servicio> buscarServicio(@PathVariable Long id_servicio){
        Servicio servicio = servicioService.buscarServicio(id_servicio);
        if(servicio == null){
            logger.error("No se encontro el servicio indicado");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        return ResponseEntity.ok(servicio);

    
    }

    @PutMapping("/editar/{id_servicio}")
    
    public ResponseEntity <Servicio> editarServicio(@PathVariable Long id_servicio, @RequestBody Servicio servicioRecibido){
        Servicio editarServicio = servicioService.buscarServicio(id_servicio);
        if(editarServicio == null){
            logger.error("No se encontro el servicio solicitado");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            editarServicio.setNombre(servicioRecibido.getNombre());
            servicioService.guardarServicio(editarServicio);
            logger.info("Se ha editado correctamente");

        }
        return ResponseEntity.ok(editarServicio);

    }
   
}
