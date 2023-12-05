package com.compunet.tienda.persistence.repositories;

import com.compunet.tienda.persistence.models.Producto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class ProductoRepository {
    private final Map<Integer, Producto> productos = new HashMap<>();
    private final AtomicInteger idGenerator = new AtomicInteger();

    public Producto findById(int idProducto) {
        return productos.get(idProducto);
    }

    public Producto save(Producto producto) {
        if (producto.getIdProducto() == 0) {
            producto.setIdProducto(idGenerator.incrementAndGet());
        }
        productos.put(producto.getIdProducto(), producto);
        return producto;
    }
}
