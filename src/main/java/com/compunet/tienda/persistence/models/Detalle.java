package com.compunet.tienda.persistence.models;


import org.springframework.stereotype.Component;


public class Detalle {
    private int numDetalle;
    private Factura factura;
    private Producto producto;
    private int cantidad;
    private double precio;

    public Detalle(int numDetalle, Factura factura, Producto producto, int cantidad, double precio) {
        this.numDetalle = numDetalle;
        this.factura = factura;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getNumDetalle() {
        return numDetalle;
    }

    public void setNumDetalle(int numDetalle) {
        this.numDetalle = numDetalle;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
