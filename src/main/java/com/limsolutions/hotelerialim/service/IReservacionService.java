package com.limsolutions.hotelerialim.service;

import java.util.List;

import com.limsolutions.hotelerialim.models.Reservacion;

public interface IReservacionService {
    public List<Reservacion> listarReservaciones();
 
    public Reservacion buscarReservacion(Long id);
 
    public Reservacion registrarReservacion(Reservacion reservacion);

}
