package com.compunet.tienda.controllers;

import com.compunet.tienda.persistence.models.Cliente;
import com.compunet.tienda.persistence.models.Detalle;
import com.compunet.tienda.services.ClienteService;
import com.compunet.tienda.services.DetalleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DetalleController {

    private final DetalleService detalleService;

    public DetalleController(DetalleService detalleService) {
        this.detalleService = detalleService;
    }

    @GetMapping("/detalles/{numFactura}")
    public List<Detalle> obtenerDetallesPorFactura(@PathVariable int numFactura) {
        List<Detalle> detalles = detalleService.obtenerDetallesPorFactura(numFactura);
        if (detalles == null || detalles.isEmpty()) {
            System.out.println("Detalles no encontrados");
        }
        return detalles;
    }
}
