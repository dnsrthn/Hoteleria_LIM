package com.limsolutions.hotelerialim.service;

import java.util.List;

import com.limsolutions.hotelerialim.models.Eventos;

public interface IEventosService {

    public List<Eventos> listarEventos();

    public Eventos buscarEvento(Long id);

    public Eventos guardarEvento(Eventos eventos);

}