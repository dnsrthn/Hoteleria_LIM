package com.limsolutions.hotelerialim.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.limsolutions.hotelerialim.models.Cliente;

public interface ClienteRepository extends JpaRepository <Cliente,Long> {

}
