package com.limsolutions.hotelerialim.service;

import java.util.List;

import com.limsolutions.hotelerialim.models.Servicio;



public interface IServicioService {

    public List<Servicio> listarServicios();
    
    public Servicio buscarServicio(Long id_servicio);

    public Servicio guardarServicio (Servicio servicio);

    public void eliminarServicio (Servicio servicio);

}
