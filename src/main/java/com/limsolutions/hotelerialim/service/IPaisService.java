package com.limsolutions.hotelerialim.service;

import java.util.List;

import com.limsolutions.hotelerialim.models.Pais;

public interface IPaisService {
    public List<Pais> listarPaices();
 
    public Pais buscarPais (Long idPais);
 
    public Pais registrarPais(Pais pais);

    public void eliminarPais(Pais pais);

}
