package com.limsolutions.hotelerialim.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.limsolutions.hotelerialim.models.Hotel;
import com.limsolutions.hotelerialim.repository.HotelRepository;


@Service // comunica el servicio con el modelo para utilizar
public class HotelService implements IHotelService{
    @Autowired // maneja las dependencias por si solo // comunica el bean con el modelo para utilizar
    private HotelRepository hotelRepository;

    @Override
    public Hotel registrarHotel(Hotel hotelGuardar) {
            return hotelRepository.save(hotelGuardar);   
    }

    @Override
    public List<Hotel> listarHoteles() {
        return hotelRepository.findAll();
    }
 
    @Override
    public Hotel buscarHotel(Long id_Hotel) {
        Hotel hotel = hotelRepository.findById(id_Hotel).orElse(null);
        return hotel;
    }

}
