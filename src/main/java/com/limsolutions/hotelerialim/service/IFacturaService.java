package com.limsolutions.hotelerialim.service;

import java.util.List;

import com.limsolutions.hotelerialim.models.Factura;

public interface IFacturaService {
    public List<Factura> listarFacturas();
 
    public Factura buscarFactura (Long id);
 
    public Factura registrarFactura(Factura factura);

}
