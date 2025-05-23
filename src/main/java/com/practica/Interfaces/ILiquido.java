package com.practica.Interfaces;

/**
 * Interfaz que define el comportamiento básico de un liquido.
 * Incluye métodos para establecer y obtener la el volumen y el tipo de envase.
 * 
 * Esta interfaz puede ser implementada por cualquier clase que represente
 * un liquido dentro del sistema.
 * 
 * @author Carlos Barrera Babiloni
 */
public interface ILiquido {
    void setVolumen(float volumen);
    float getVolumen();
    void setTipoEnvase(String tipoEnvase);
    String getTipoEnvase();
}
