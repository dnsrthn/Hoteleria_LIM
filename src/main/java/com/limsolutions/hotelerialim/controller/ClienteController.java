package com.limsolutions.hotelerialim.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.limsolutions.hotelerialim.DTOS.EstadoDto;
import com.limsolutions.hotelerialim.models.Cliente;
import com.limsolutions.hotelerialim.service.ClienteService;

@RestController
@RequestMapping ("HoteleriaLIMSolutions/v1/Cliente")

public class ClienteController  {

    @Autowired
    private ClienteService clienteService;


    private static final Logger logger = LoggerFactory.getLogger(ClienteController.class);

    @GetMapping("/listar_clientes")
    public List<Cliente> listarClientes(){
        var cliente2 =  clienteService.listarClientes();
        cliente2.forEach((cliente -> logger.info(cliente.toString())));
        return cliente2;
    }

    @PostMapping("/agregar_cliente")
    public Cliente agregarCliente (@RequestBody Cliente cliente){
        logger.info("El cliente ya a sido agregado" + cliente);
        return clienteService.registrarCliente(cliente);
    }

    @GetMapping("/buscar_cliente/{id}")
    public ResponseEntity <Cliente> buscarCliente(@PathVariable Long id){
        Cliente cliente = clienteService.buscarCliente(id);
        if(cliente == null){
            logger.error("No se pudo encontrar el cliente indicado");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(cliente);
    }

        @PutMapping("/editar_cliente/{id}")
        public ResponseEntity <Cliente> editarCliente (@PathVariable Long id, @RequestBody Cliente cliente){
            Cliente clienteEditar = clienteService.buscarCliente(id);

            if(clienteEditar == null){
                logger.error("No se pudo encontrar el cliente indicado");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }else{
                    clienteEditar.setNombreCompleto(cliente.getNombreCompleto());
                    clienteEditar.setCorreo(cliente.getCorreo());
                    clienteEditar.setEstado(cliente.getEstado());
                    clienteEditar.setTelefono(cliente.getTelefono());
                    clienteService.registrarCliente(clienteEditar);
                    logger.info("Guardando cliente modificado");
                }
                    return ResponseEntity.ok(clienteEditar);
        }

        @PutMapping("estado_cliente/{id}")
        public ResponseEntity<Cliente> actualizarEstado(@PathVariable Long id,@RequestBody EstadoDto estado) {
            Cliente clienteEditar = clienteService.buscarCliente(id);

            if(clienteEditar == null){
                logger.error("No se pudo encontrar el cliente indicado");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }else{
                    clienteEditar.setNombreCompleto(clienteEditar.getNombreCompleto());
                    clienteEditar.setCorreo(clienteEditar.getCorreo());
                    clienteEditar.setEstado(estado.getEstado());
                    clienteEditar.setTelefono(clienteEditar.getTelefono());
                    clienteService.registrarCliente(clienteEditar);
                    logger.info("Guardando estado del cliente modificado");
                }
                    return ResponseEntity.ok(clienteEditar);
        }

}
