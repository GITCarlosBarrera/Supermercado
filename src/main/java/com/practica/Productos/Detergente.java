package com.practica.Productos;

import com.practica.Interfaces.IDescuento;
import com.practica.Interfaces.ILiquido;

/**
 * Clase que representa un detergente.
 * Hereda atributos comunes de la clase Producto e implementa la interfaz ILiquido e IDescuento.
 * 
 * Incluye información específica como el volumen, el tipo de envase y el descuento.
 * 
 * @author Carlos Barrera Babiloni
 */
public class Detergente extends Producto implements ILiquido, IDescuento {
    private float volumen;
    private String tipoEnvase;
    private float descuento; // Porcentaje de descuento

    
    /**
     * Crea un objeto Detergente con la información mínima requerida: marca y precio.
     *
     * @param marca Marca del detergente.
     * @param precio Precio del detergente.
     */
    public Detergente(String marca, float precio) {
        super(marca, precio);
    }
    
    
    /**
     * Crea un objeto Detergente con todos los atributos especificados.
     *
     * @param marca Marca del detergente.
     * @param precio Precio del detergente.
     * @param volumen Volumen del envase en litros.
     * @param tipoEnvase Tipo de envase.
     * @param descuento Porcentaje de descuento aplicado al producto.
     */
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

    /**
     * Devuelve una representación detallada del objeto Detergente,
     * incluyendo marca, volumen, tipo de envase, precio, descuento y precio con descuento.
     *
     * @return Cadena con la información completa del detergente.
     */
    @Override
    public String toString() {
        return "Detergente:" 
                + "\n\tMarca: " + getMarca()
                + (volumen > 0 ? "\n\tVolumen: " + volumen : "")
                + (tipoEnvase != null ? "\n\tEnvase: " + tipoEnvase : "")
                + "\n\tPrecio: " + getPrecio() + "€"
                + (descuento > 0 
                    ? "\n\tDescuento: " + descuento + "%"
                    + "\n\tPrecio con descuento: " 
                    + getPrecioDescuento() + "€" : "");
    }

    /**
     * Devuelve una representación simplificada del Detergente,
     * útil para listados breves o vistas resumidas.
     *
     * @return Cadena con información básica del detergente.
     */
    @Override
    public String toSimpleString() {
        return "Detergente - Marca: " + getMarca() + "- Precio: " + getPrecio() + "€";
    }
}