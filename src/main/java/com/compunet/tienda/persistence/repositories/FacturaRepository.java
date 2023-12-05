package com.compunet.tienda.persistence.repositories;

import com.compunet.tienda.persistence.models.Factura;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class FacturaRepository {
    private final Map<Integer, Factura> facturas = new HashMap<>();
    private final AtomicInteger idGenerator = new AtomicInteger();

    public Factura findById(int numFactura) {
        return facturas.get(numFactura);
    }

    public List<Factura> findByClienteId(int idCliente) {
        List<Factura> result = new ArrayList<>();
        for (Factura factura : facturas.values()) {
            if (factura.getCliente().getIdCliente() == idCliente) {
                result.add(factura);
            }
        }
        return result;
    }

    public Factura save(Factura factura) {
        if (factura.getNumFactura() == 0) {
            factura.setNumFactura(idGenerator.incrementAndGet());
        }
        facturas.put(factura.getNumFactura(), factura);
        return factura;
    }
}
