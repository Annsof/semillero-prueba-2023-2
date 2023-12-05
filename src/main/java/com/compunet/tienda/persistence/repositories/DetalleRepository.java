package com.compunet.tienda.persistence.repositories;

import com.compunet.tienda.persistence.models.Detalle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class DetalleRepository {
    private final Map<Integer, Detalle> detalles = new HashMap<>();
    private final AtomicInteger idGenerator = new AtomicInteger();

    public List<Detalle> findByFacturaNum(int numFactura) {
        List<Detalle> result = new ArrayList<>();
        for (Detalle detalle : detalles.values()) {
            if (detalle.getFactura().getNumFactura() == numFactura) {
                result.add(detalle);
            }
        }
        return result;
    }

    public Detalle save(Detalle detalle) {
        if (detalle.getNumDetalle() == 0) {
            detalle.setNumDetalle(idGenerator.incrementAndGet());
        }
        detalles.put(detalle.getNumDetalle(), detalle);
        return detalle;
    }
}
