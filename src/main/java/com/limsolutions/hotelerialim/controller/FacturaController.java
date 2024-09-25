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

import com.limsolutions.hotelerialim.models.Factura;
import com.limsolutions.hotelerialim.service.FacturaService;

@RestController
@RequestMapping ("HoteleriaLIMSolutions/v1/Factura")

public class FacturaController  {

    @Autowired
    private FacturaService facturaService;


    private static final Logger logger = LoggerFactory.getLogger(FacturaController.class);

    @GetMapping("/listar_facturas")
    public List<Factura> listarFacturas(){
        var factura2 =  facturaService.listarFacturas();
        factura2.forEach((factura -> logger.info(factura.toString())));
        return factura2;
    }

    @PostMapping("/agregar_factura")
    public Factura agregarFactura (@RequestBody Factura factura){
        logger.info("La factura a sido agregada" + factura);
        return facturaService.registrarFactura(factura);
    }

    @GetMapping("/buscar_factura/{id}")
    public ResponseEntity <Factura> buscarFactura(@PathVariable Long id){
        Factura factura = facturaService.buscarFactura(id);
        if(factura == null){
            logger.error("No se pudo encontrar la factura indicada");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(factura);
    }

        @PutMapping("/editar_factura/{id}")
        public ResponseEntity <Factura> editarFactura (@PathVariable Long id, @RequestBody Factura factura){
            Factura facturaEditar = facturaService.buscarFactura(id);
        if(facturaEditar == null){
            logger.error("No se pudo encontrar la factura indicada");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }else{
                facturaEditar.setImpuestos(factura.getImpuestos());
                facturaEditar.setTarifa(factura.getTarifa());
                facturaEditar.setTotal(factura.getTotal());
                facturaEditar.setId_cliente(factura.getId_cliente());
                facturaEditar.setId_hotel(factura.getId_hotel());
                facturaEditar.setId_reservacion(factura.getId_reservacion());
                facturaService.registrarFactura(facturaEditar);
                    logger.info("Guardando factura modificada");
                }
                    return ResponseEntity.ok(facturaEditar);
        }
}
