package com.practica.Productos;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

import com.practica.Interfaces.IAlimento;

/**
 * Clase que representa un cereal.
 * Hereda atributos comunes de la clase Producto e implementa la interfaz IAlimento.
 * 
 * Incluye información específica como el tipo de cereal, la fecha de caducidad y el contenido calórico.
 * 
 * @author Carlos Barrera Babiloni
 */
public class Cereal extends Producto implements IAlimento {
    private String tipoCereal;
    private Date caducidad;
    private int calorias;    

    /**
     * Crea un nuevo objeto de tipo Cereal con la marca, precio y tipo de cereal.
     * Asigna automáticamente las calorías en función del tipo de cereal y establece
     * la fecha de caducidad a un mes desde la fecha actual.
     *
     * @param marca Marca del cereal.
     * @param precio Precio del cereal.
     * @param tipoCereal Tipo de cereal.
     */
    public Cereal(String marca, float precio, String tipoCereal) {
        super(marca, precio);
        this.tipoCereal = tipoCereal;

        switch (tipoCereal.toUpperCase()) {
            case "ESPELTA":
                calorias = 5;
                break;
            
            case "MAIZ":
                calorias = 8;
                break;
                
            case "TRIGO":
                calorias = 12;
                break;

            default:
                calorias = 15;
                break;
        }

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 1);
        this.caducidad = cal.getTime();
    }

    public String getTipoCereal() {
        return tipoCereal;
    }

    public void setTipoCereal(String tipoCereal) {
        this.tipoCereal = tipoCereal;
    }

    @Override
    public Date getCaducidad() {
        return caducidad;
    }

    @Override
    public void setCaducidad(Date caducidad) {
        this.caducidad = caducidad;
    }

    @Override
    public int getCalorias() {
        return calorias;
    }

    
    /**
     * Devuelve una representación detallada del objeto Cereal,
     * incluyendo marca, tipo, calorías, fecha de caducidad y precio.
     *
     * @return Cadena con la información completa del cereal.
     */
    @Override
    public String toString() {
        String fechaCaducidad = "--/----";

        if (caducidad != null) {
            SimpleDateFormat formato = new SimpleDateFormat("MM/yyyy");
            fechaCaducidad = formato.format(caducidad);
        }


        return "Cereal:" 
                + "\n\tMarca: " + getMarca()
                + "\n\tTipo de cereal: " + tipoCereal
                + "\n\tCalorias: " + calorias
                +"\n\tFecha de caducidad: " + fechaCaducidad
                + "\n\tPrecio: " + getPrecio() + "€";
    }

    
    /**
     * Devuelve una representación simplificada del cereal,
     * útil para listados breves o vistas resumidas.
     *
     * @return Cadena con información básica del cereal.
     */
    @Override
    public String toSimpleString() {
        return "Cereal - Marca: " + getMarca() + " - Tipo de cereal: " + tipoCereal + "- Precio: " + getPrecio() + "€";
    }
}
