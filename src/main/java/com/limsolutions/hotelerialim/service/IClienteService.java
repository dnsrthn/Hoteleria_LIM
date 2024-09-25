package com.limsolutions.hotelerialim.service;

import java.util.List;

import com.limsolutions.hotelerialim.models.Cliente;

public interface IClienteService {
    public List<Cliente> listarClientes();
 
    public Cliente buscarCliente (Long idCliente);
 
    public Cliente registrarCliente(Cliente cliente);
}
