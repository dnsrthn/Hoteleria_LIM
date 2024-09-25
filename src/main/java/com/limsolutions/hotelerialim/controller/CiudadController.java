package com.limsolutions.hotelerialim.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.limsolutions.hotelerialim.models.Ciudad;
import com.limsolutions.hotelerialim.service.CiudadService;

@RestController
@RequestMapping("HoteleriaLIMSolutions/v1/Ciudad")
public class CiudadController {

    private static final Logger logger = LoggerFactory.getLogger(CiudadController.class);

    @Autowired
    private CiudadService ciudadService;

    @PostMapping("/agregar_ciudad")
    public Ciudad agregarCiudad(@RequestBody Ciudad ciudad) {
        logger.info("Ciudad agregada" + ciudad);
        return ciudadService.registrarCiudad(ciudad);
    }

    @GetMapping("/listar_ciudades")
    public List<Ciudad> listarCiudades() {
        var ciudad2 = ciudadService.listarCiudades();
        ciudad2.forEach(ciudad -> logger.info(ciudad.toString()));
        return ciudad2;
    }

    @GetMapping("/buscar_ciudad/{id}")
    public ResponseEntity<Ciudad> buscarHabitacion(@PathVariable Long id) {
        Ciudad ciudad = ciudadService.buscarCiudad(id);
        return ResponseEntity.ok(ciudad);
    }


    @PutMapping("/editar_ciudad/{id}")
    public ResponseEntity<Ciudad> editarHabitacion(@PathVariable Long id,
            @RequestBody Ciudad ciudadRecibida) {
        Ciudad ciudad = ciudadService.buscarCiudad(id);

        ciudad.setNombre(ciudadRecibida.getNombre());
        ciudad.setId_pais(ciudadRecibida.getId_pais());
        ciudadService.registrarCiudad(ciudad);

        return ResponseEntity.ok(ciudad);
    }

    @DeleteMapping("/eliminar_ciudad/{id}")
    public void eliminarEmpleado(@PathVariable Long id){
        Ciudad ciudad = ciudadService.buscarCiudad(id);
        if(ciudad == null){
            logger.error("No se pudo encontrar el hotel indicado");
        }
        ciudadService.eliminarCiudad(ciudad);
        logger.info("Ciudad:" + ciudad + " eliminada");
    }
}
