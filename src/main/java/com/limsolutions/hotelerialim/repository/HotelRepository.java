package com.limsolutions.hotelerialim.repository;

import com.limsolutions.hotelerialim.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {

    List<Hotel> findByDireccion(int id_hotel);
}
