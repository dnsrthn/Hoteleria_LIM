package com.limsolutions.hotelerialim.service;
    import java.util.List;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    
    import com.limsolutions.hotelerialim.models.Reservacion;
    import com.limsolutions.hotelerialim.repository.ReservacionRepository;
    
    
    @Service // comunica el servicio con el modelo para utilizar
    public class ReservacionService implements IReservacionService{
        @Autowired // maneja las dependencias por si solo // comunica el bean con el modelo para utilizar
        private ReservacionRepository reservacionRepository;
    
        @Override
        public Reservacion registrarReservacion(Reservacion reservacion) {
                return reservacionRepository.save(reservacion);   
        }
    
        @Override
        public List<Reservacion> listarReservaciones() {
            return reservacionRepository.findAll();
        }
     
        @Override
        public Reservacion buscarReservacion(Long id) {
            Reservacion reservacion = reservacionRepository.findById(id).orElse(null);
            return reservacion;
        }
    
    }
