package com.compunet.tienda.controllers;

import com.compunet.tienda.persistence.models.Cliente;
import com.compunet.tienda.persistence.models.Factura;
import com.compunet.tienda.services.ClienteService;
import com.compunet.tienda.services.FacturaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class FacturaController {
    private final FacturaService facturaService;

    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    @GetMapping("/facturas/{numFactura}")
    public Factura obtenerFacturaPorNumero(@PathVariable int numFactura) {
        Factura factura = facturaService.obtenerFacturaPorNumero(numFactura);
        if (factura == null) {
            System.out.println("Factura no encontrada");
        }
        return factura;
    }

    @GetMapping("/facturas/{numFactura}/total")
    public double obtenerTotalFactura(@PathVariable int numFactura) {
        Factura factura = facturaService.obtenerFacturaPorNumero(numFactura);
        if (factura == null) {
            System.out.println("Factura no encontrada");
        }
        return facturaService.calcularTotalFactura(numFactura);
    }
}
