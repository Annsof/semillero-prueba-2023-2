package com.compunet.tienda.controllers;

import com.compunet.tienda.persistence.models.Cliente;
import com.compunet.tienda.services.ClienteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/clientes/{id}")
    public Cliente obtenerClientePorId(@PathVariable int id) {
        Cliente cliente = clienteService.obtenerClientePorId(id);
        if (cliente == null) {
            System.out.println("Cliente no encontrado");
        }
        return cliente;
    }
}
