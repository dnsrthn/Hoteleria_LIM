package com.limsolutions.hotelerialim.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.limsolutions.hotelerialim.models.Hotel;

public interface  HotelRepository extends JpaRepository<Hotel, Long> {

}
