package com.limsolutions.hotelerialim.service;
import java.util.List;

import com.limsolutions.hotelerialim.models.Hotel;

public interface IHotelService {

    public List<Hotel> listarHoteles();
 
    public Hotel buscarHotel (Long id_Hotel);
 
    public Hotel registrarHotel(Hotel hotelAgregar);

}
