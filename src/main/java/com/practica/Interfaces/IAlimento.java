package com.practica.Interfaces;

import java.util.Date;

/**
 * Interfaz que define el comportamiento básico de un alimento.
 * Incluye métodos para establecer y obtener la fecha de caducidad,
 * así como para consultar su contenido calórico.
 * 
 * Esta interfaz puede ser implementada por cualquier clase que represente
 * un producto alimenticio dentro del sistema.
 * 
 * @author Carlos Barrera Babiloni
 */
public interface IAlimento {
    void setCaducidad(Date fecha);
    Date getCaducidad();
    int getCalorias();
}
