package com.limsolutions.hotelerialim.service;
    import java.util.List;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    
    import com.limsolutions.hotelerialim.models.Ciudad;
import com.limsolutions.hotelerialim.repository.CiudadRepository;
    
    
    @Service // comunica el servicio con el modelo para utilizar
    public class CiudadService implements ICiudadService{
        @Autowired // maneja las dependencias por si solo // comunica el bean con el modelo para utilizar
        private CiudadRepository ciudadRepository;
    
        @Override
        public Ciudad registrarCiudad(Ciudad ciudad) {
                return ciudadRepository.save(ciudad);   
        }
    
        @Override
        public List<Ciudad> listarCiudades() {
            return ciudadRepository.findAll();
        }
     
        @Override
        public Ciudad buscarCiudad(Long id) {
            Ciudad ciudad = ciudadRepository.findById(id).orElse(null);
            return ciudad;
        }

        @Override
        public void eliminarCiudad(Ciudad ciudad) {
            ciudadRepository.delete(ciudad);
        }
    
    }
