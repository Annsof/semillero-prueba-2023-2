
package com.compunet.tienda;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.compunet.tienda.persistence.models.Cliente;
import com.compunet.tienda.persistence.models.Detalle;
import com.compunet.tienda.persistence.models.Factura;
import com.compunet.tienda.persistence.models.Producto;
import com.compunet.tienda.services.ClienteService;
import com.compunet.tienda.services.DetalleService;
import com.compunet.tienda.services.FacturaService;
import com.compunet.tienda.services.ProductoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TiendaApplication {


    public static void main(String[] args) throws ParseException {
        ConfigurableApplicationContext context = SpringApplication.run(TiendaApplication.class, args);
        ClienteService clienteService = context.getBean(ClienteService.class);
        ProductoService productoService = context.getBean(ProductoService.class);
        FacturaService facturaService = context.getBean(FacturaService.class);
        DetalleService detalleService = context.getBean(DetalleService.class);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaNacimiento = sdf.parse("01/01/1980");

        Cliente cliente = new Cliente(1, "Juan", "Pérez", "Calle Nose 123", fechaNacimiento, "3001234567", "juan.perez@example.com", "Regular");
        clienteService.save(cliente);

        Producto producto1 = new Producto(1, "Producto1", 500000, 10);
        Producto producto2 = new Producto(2, "Producto2", 600000, 10);
        productoService.save(producto1);
        productoService.save(producto2);

        Factura factura = new Factura(1, cliente, new Date());

        List<Detalle> listaDetalles = new ArrayList<>();

        Detalle detalle1 = new Detalle(1, factura, producto1, 5, producto1.getPrecio());
        Detalle detalle2 = new Detalle(2, factura, producto2, 3, producto2.getPrecio());

        listaDetalles.add(detalle1);
        listaDetalles.add(detalle2);

        detalleService.save(detalle1);
        detalleService.save(detalle2);

        factura.setDetalles(listaDetalles);

        facturaService.save(factura);



        double totalFactura = facturaService.calcularTotalFactura(factura.getNumFactura());
        System.out.println("Total Factura: " + totalFactura);
    }


}
