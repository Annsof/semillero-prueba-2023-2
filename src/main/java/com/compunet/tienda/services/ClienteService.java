package com.compunet.tienda.services;

import com.compunet.tienda.persistence.models.Cliente;
import com.compunet.tienda.persistence.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente obtenerClientePorId(int idCliente) {
        return clienteRepository.findById(idCliente);
    }
    public void save(Cliente cliente){clienteRepository.save(cliente);}
}
