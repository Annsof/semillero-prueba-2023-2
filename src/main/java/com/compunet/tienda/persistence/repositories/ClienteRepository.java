package com.compunet.tienda.persistence.repositories;

import com.compunet.tienda.persistence.models.Cliente;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class ClienteRepository{
    private final Map<Integer, Cliente> clientes = new HashMap<>();
    private final AtomicInteger idGenerator = new AtomicInteger();

    public Cliente findById(int idCliente) {
        return clientes.get(idCliente);
    }

    public Cliente save(Cliente cliente) {
        if (cliente.getIdCliente() == 0) {
            cliente.setIdCliente(idGenerator.incrementAndGet());
        }
        clientes.put(cliente.getIdCliente(), cliente);
        return cliente;
    }
}
