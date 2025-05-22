package com.practica.Productos;

public abstract class Producto {
    private String marca;
    private float precio;

    public Producto(String marca, float precio) {
        this.marca = marca;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public abstract String toString();

    public abstract String toSimpleString();
}
