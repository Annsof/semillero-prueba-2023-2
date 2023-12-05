package com.compunet.tienda.controllers;

import com.compunet.tienda.persistence.models.Cliente;
import com.compunet.tienda.persistence.models.Producto;
import com.compunet.tienda.services.ClienteService;
import com.compunet.tienda.services.ProductoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/productos/{idProducto}")
    public Producto obtenerProductoPorId(@PathVariable int idProducto) {
        Producto producto = productoService.obtenerProductoPorId(idProducto);
        if (producto == null) {
            System.out.println("Producto no encontrado");
        }
        return producto;
    }
}
