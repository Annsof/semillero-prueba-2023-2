package com.compunet.tienda.persistence.models;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;



public class Factura {
    private int numFactura;
    private Cliente cliente;
    private Date fecha;
    private List<Detalle> detalles;

    public Factura(int numFactura, Cliente cliente, Date fecha) {
        this.numFactura = numFactura;
        this.cliente = cliente;
        this.fecha = fecha;

    }

    public int getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(int numFactura) {
        this.numFactura = numFactura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Detalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<Detalle> detalles) {
        this.detalles = detalles;
    }
}
