package com.limsolutions.hotelerialim.service;
    import java.util.List;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    
    import com.limsolutions.hotelerialim.models.Cliente;
    import com.limsolutions.hotelerialim.repository.ClienteRepository;
    
    
    @Service // comunica el servicio con el modelo para utilizar
    public class ClienteService implements IClienteService{
        @Autowired // maneja las dependencias por si solo // comunica el bean con el modelo para utilizar
        private ClienteRepository clienteRepository;
    
        @Override
        public Cliente registrarCliente(Cliente cliente) {
                return clienteRepository.save(cliente);   
        }
    
        @Override
        public List<Cliente> listarClientes() {
            return clienteRepository.findAll();
        }
     
        @Override
        public Cliente buscarCliente(Long id) {
            Cliente cliente = clienteRepository.findById(id).orElse(null);
            return cliente;
        }
    
    }
