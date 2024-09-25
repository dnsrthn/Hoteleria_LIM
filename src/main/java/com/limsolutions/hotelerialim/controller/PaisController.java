package com.limsolutions.hotelerialim.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.limsolutions.hotelerialim.models.Pais;
import com.limsolutions.hotelerialim.service.PaisService;
@RestController
@RequestMapping("HoteleriaLIMSolutions/v1/Pais")

public class PaisController {

    private static final Logger logger = LoggerFactory.getLogger(PaisController.class);

    @Autowired
    private PaisService paisService;

    @PostMapping("/agregar_pais")
    public Pais agregarPais(@RequestBody Pais pais) {
        logger.info("Pais agregado: " + pais);
        return paisService.registrarPais(pais);
    }

    @GetMapping("/listar_paices")
    public List<Pais> listarPaices() {
        var pais2 = paisService.listarPaices();
        pais2.forEach(pais -> logger.info(pais.toString()));
        return pais2;
    }

    @GetMapping("/buscar_pais/{id}")
    public ResponseEntity <Pais> buscarPais(@PathVariable Long id){
        Pais pais = paisService.buscarPais(id);
        if(pais == null){
            logger.error("No se pudo encontrar el pais indicado");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(pais);
    }


    @PutMapping("/editar_pais/{id}")
    public ResponseEntity<Pais> editarPais(@PathVariable Long id,
            @RequestBody Pais paisRecibido) {
        Pais pais = paisService.buscarPais(id);

        if(pais == null){
            logger.error("No se pudo encontrar el pais indicado");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        pais.setNombre(paisRecibido.getNombre());
        paisService.registrarPais(pais);

        return ResponseEntity.ok(pais);
    }

    @DeleteMapping("/eliminar_pais/{id}")
    public void eliminarPais(@PathVariable Long id){
        Pais pais = paisService.buscarPais(id);
        if(pais == null){
            logger.error("No se pudo encontrar el pais indicado");
        }
        paisService.eliminarPais(pais);
        logger.info("Pais:" + pais + " eliminado");
    }

}
