package com.practica.Productos;

import com.practica.Interfaces.IDescuento;
import com.practica.Interfaces.ILiquido;

public class Detergente extends Producto implements ILiquido, IDescuento {
    private float volumen;
    private String tipoEnvase;
    private float descuento; // Porcentaje de descuento

    public Detergente(String marca, float precio) {
        super(marca, precio);
        volumen = -1;
        tipoEnvase = null;
        descuento = -1;
    }
    
    public Detergente(String marca, float precio, float volumen, String tipoEnvase, float descuento) {
        super(marca, precio);
        this.volumen = volumen;
        this.tipoEnvase = tipoEnvase;
        this.descuento = descuento;
    }

    @Override
    public float getVolumen() {
        return volumen;
    }
    
    @Override
    public void setVolumen(float volumen) {
        this.volumen = volumen;
    }

    @Override
    public String getTipoEnvase() {
        return tipoEnvase;
    }

    @Override
    public void setTipoEnvase(String tipoEnvase) {
        this.tipoEnvase = tipoEnvase;
    }

    @Override
    public float getDescuento() {
        return descuento;
    }

    @Override
    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    @Override
    public float getPrecioDescuento() {
        return getPrecio() * (1 - descuento / 100);
    }

    @Override
    public String toString() {
        return "Detergente:" 
                + "\n\tMarca: " + getMarca()
                + (volumen != -1 ? "\n\tVolumen: " + volumen : "")
                + (tipoEnvase != null ? "\n\tEnvase: " + tipoEnvase : "")
                + "\n\tPrecio: " + getPrecio() + "€"
                + (descuento > 0 
                    ? "\n\tDescuento: " + descuento + "%"
                    + "\n\tPrecio con descuento: " 
                    + getPrecioDescuento() + "€" : "");
    }

    
    @Override
    public String toSimpleString() {
        return "Detergente - Marca: " + getMarca() + "- Precio: " + getPrecio() + "€";
    }
}