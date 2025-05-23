package com.practica.Interfaces;

/**
 * Interfaz que define el comportamiento básico de un producto al que se
 * le pueden aplicar descuentos.
 * Incluye métodos para establecer y obtener la el porcentaje de descuento,
 * así como para calcular el precio con descuento.
 * 
 * Esta interfaz puede ser implementada por cualquier clase que represente
 * un producto al que se le pueden aplicar descuentos.
 * 
 * @author Carlos Barrera Babiloni
 */
public interface IDescuento {
    void setDescuento(float descuento); // Porcentaje de descuento
    float getDescuento();
    float getPrecioDescuento();
}
