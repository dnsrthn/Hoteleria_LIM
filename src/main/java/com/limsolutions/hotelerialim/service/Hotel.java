package com.limsolutions.hotelerialim.service;

import com.limsolutions.hotelerialim.models.Hotel;

import java.util.ArrayList;
import java.util.List;

public class HotelService implements IHotel {
    private List<Hotel> hoteles = new ArrayList<>();

    @Override
    public void registrarHotel(Hotel hotel) {
        hoteles.add(hotel);
    }

    @Override
    public void actualizarHotel(Hotel hotel) {
        for (int i = 0; i < hoteles.size(); i++) {
            if (hoteles.get(i).getId() == hotel.getId()) {
                hoteles.set(i, hotel);
                return;
            }
        }
    }

    @Override
    public List<Hotel> obtenerHoteles() {
        return hoteles;
    }

    @Override
    public Hotel obtenerHotelId(int idHotel) {
        return hoteles.stream()
                .filter(h -> h.getId() == id_hotel)
                .findFirst() //no es necesario importar las dependencias de stream para usar FindFirst
                .orElse(null);
    }
}
