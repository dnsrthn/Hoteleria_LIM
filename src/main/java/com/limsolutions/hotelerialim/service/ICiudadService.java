package com.limsolutions.hotelerialim.service;

import java.util.List;

import com.limsolutions.hotelerialim.models.Ciudad;

public interface ICiudadService {

    public List<Ciudad> listarCiudades();
 
    public Ciudad buscarCiudad (Long idCiudad);
 
    public Ciudad registrarCiudad(Ciudad ciudad);

    public void eliminarCiudad(Ciudad ciudad);
}
