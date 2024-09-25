package com.limsolutions.hotelerialim.service;
    import java.util.List;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    
    import com.limsolutions.hotelerialim.models.Pais;
    import com.limsolutions.hotelerialim.repository.PaisRepository;
    
    
    @Service // comunica el servicio con el modelo para utilizar
    public class PaisService implements IPaisService{
        @Autowired // maneja las dependencias por si solo // comunica el bean con el modelo para utilizar
        private PaisRepository paisRepository;
    
        @Override
        public Pais registrarPais(Pais pais) {
                return paisRepository.save(pais);   
        }
    
        @Override
        public List<Pais> listarPaices() {
            return paisRepository.findAll();
        }
     
        @Override
        public Pais buscarPais(Long id) {
            Pais pais = paisRepository.findById(id).orElse(null);
            return pais;
        }

        @Override
        public void eliminarPais(Pais pais) {
            paisRepository.delete(pais);
        }
    
    }
