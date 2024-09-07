package com.limsolutions.hotelerialim.service;

import com.limsolutions.hotelerialim.models.Hotel;
import java.util.List;

public interface IHotel {
    void registrarHotel(Hotel hotel);
    void actualizarHotel(Hotel hotel);
    List<Hotel> obtenerHoteles();
    Hotel obtenerHotelPorId(int idHotel);
}