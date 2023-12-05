package com.compunet.tienda.services;

import com.compunet.tienda.persistence.models.Detalle;
import com.compunet.tienda.persistence.repositories.DetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DetalleService {

    @Autowired
    private final DetalleRepository detalleRepository;

    public DetalleService(DetalleRepository detalleRepository) {
        this.detalleRepository = detalleRepository;
    }

    public List<Detalle> obtenerDetallesPorFactura(int numFactura) {
        return detalleRepository.findByFacturaNum(numFactura);
    }
    public void save(Detalle detalle){detalleRepository.save(detalle);}
}
