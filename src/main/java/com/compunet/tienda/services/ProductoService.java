package com.compunet.tienda.services;

import com.compunet.tienda.persistence.models.Producto;
import com.compunet.tienda.persistence.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    @Autowired
    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public Producto obtenerProductoPorId(int idProducto) {
        return productoRepository.findById(idProducto);
    }

    public void save(Producto producto){productoRepository.save(producto);}
}
