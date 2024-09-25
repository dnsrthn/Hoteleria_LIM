package com.limsolutions.hotelerialim.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.limsolutions.hotelerialim.models.Factura;
import com.limsolutions.hotelerialim.repository.FacturaRepository;

    @Service // comunica el servicio con el modelo para utilizar
    public class FacturaService implements IFacturaService{
        @Autowired // maneja las dependencias por si solo // comunica el bean con el modelo para utilizar
        private FacturaRepository facturaRepository;
    
        @Override
        public Factura registrarFactura(Factura factura) {
                return facturaRepository.save(factura);   
        }
    
        @Override
        public List<Factura> listarFacturas() {
            return facturaRepository.findAll();
        }
     
        @Override
        public Factura buscarFactura(Long id) {
            Factura factura = facturaRepository.findById(id).orElse(null);
            return factura;
        }
    
    }
