package com.compunet.tienda.services;

import com.compunet.tienda.persistence.models.Detalle;
import com.compunet.tienda.persistence.models.Factura;
import com.compunet.tienda.persistence.repositories.DetalleRepository;
import com.compunet.tienda.persistence.repositories.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class FacturaService {

    @Autowired
    private final FacturaRepository facturaRepository;

    @Autowired
    private final DetalleRepository detalleRepository;

    public FacturaService(FacturaRepository facturaRepository, DetalleRepository detalleRepository) {
        this.facturaRepository = facturaRepository;
        this.detalleRepository = detalleRepository;
    }
    public void save(Factura factura){facturaRepository.save(factura);}
    public Factura obtenerFacturaPorNumero(int numFactura) {
        return facturaRepository.findById(numFactura);
    }

    public double calcularTotalFactura(int numFactura) {
        List<Detalle> detalles = detalleRepository.findByFacturaNum(numFactura);
        double total = detalles.stream().mapToDouble(detalle -> detalle.getPrecio() * detalle.getCantidad()).sum();
        int cantidadItems=0;
        for (int i=0;i<detalles.size();i++){
            cantidadItems+=detalles.get(i).getCantidad();
        }

        if (total > 1000000 && cantidadItems >= 5) {
            total *= 0.9;
        }
        return total;
    }
}
