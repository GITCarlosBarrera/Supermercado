package com.practica.Productos;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.practica.Interfaces.IAlimento;
import com.practica.Interfaces.IDescuento;
import com.practica.Interfaces.ILiquido;

/**
 * Clase que representa un Vino.
 * Hereda atributos comunes de la clase Producto e implementa la interfaz ILiquido, IAlimento e IDescuento.
 * 
 * Incluye información específica como el tipo de vino, los grados de alcohol, el volumen, el tipo de envase
 * la fecha de caducidad, el contenido calórico y el descuento.
 * 
 * @author Carlos Barrera Babiloni
 */
public class Vino extends Producto implements ILiquido, IAlimento, IDescuento {
    private String tipoVino;
    private float gradosAlcohol;
    private float volumen;
    private String tipoEnvase;
    private Date caducidad;
    private int calorias;
    private float descuento; // Porcentaje de descuento

    /**
     * Crea un objeto Vino con la información mínima requerida: marca, precio, tipo de vino y grados de alcohol.
     * Asigna automáticamente las calorías en función de los grados de alcohol.
     * 
     * @param marca
     * @param precio
     * @param tipoVino
     * @param gradosAlcohol
     */
    public Vino(String marca, float precio, String tipoVino, float gradosAlcohol) {
        super(marca, precio);
        this.tipoVino = tipoVino;
        this.gradosAlcohol = gradosAlcohol;
        calorias = (int) gradosAlcohol * 10;
    }

    /**
     * Crea un objeto Vino con todos los atributos especificados.     * 
     * Asigna automáticamente las calorías en función de los grados de alcohol
     * y establece la fecha de caducidad a un mes desde la fecha actual.
     * @param marca
     * @param precio
     * @param tipoVino
     * @param gradosAlcohol
     * @param volumen
     * @param tipoEnvase
     * @param descuento
     */
    public Vino(String marca, float precio, String tipoVino, float gradosAlcohol, float volumen, String tipoEnvase, float descuento) {
        super(marca, precio);
        this.tipoVino = tipoVino;
        this.gradosAlcohol = gradosAlcohol;
        this.volumen = volumen;
        this.tipoEnvase = tipoEnvase;
        this.descuento = descuento;
        calorias = (int) gradosAlcohol * 10;

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 1);
        this.caducidad = cal.getTime();
    }

    public String getTipoVino() {
        return tipoVino;
    }

    public void setTipoVino(String tipoVino) {
        this.tipoVino = tipoVino;
    }

    public float getGradosAlcohol() {
        return gradosAlcohol;
    }

    public void setGradosAlcohol(float gradosAlcohol) {
        this.gradosAlcohol = gradosAlcohol;
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
     * Devuelve una representación detallada del objeto Vino,
     * incluyendo marca, tipo de vino, grados de alcohol, volumen, tipo de envase, calorias,
     * fecha de caducidad, precio, descuento y precio con descuento.
     *
     * @return Cadena con la información completa del vino.
     */
    @Override
    public String toString() {
        String fechaCaducidad = "--/----";

        if (caducidad != null) {
            SimpleDateFormat formato = new SimpleDateFormat("MM/yyyy");
            fechaCaducidad = formato.format(caducidad);
        }

        return "Vino:" 
                + "\n\tMarca: " + getMarca()
                + "\n\tTipo de vino: " + tipoVino
                + "\n\tGrados: " + gradosAlcohol + "º"
                + (volumen != -1 ? "\n\tVolumen: " + volumen : "")
                + (tipoEnvase != null ? "\n\tEnvase: " + tipoEnvase : "")
                + "\n\tCalorias: " + calorias
                + "\n\tFecha de caducidad: " + fechaCaducidad
                + "\n\tPrecio: " + getPrecio() + "€"
                + (descuento > 0 
                    ? "\n\tDescuento: " + descuento + "%"
                    + "\n\tPrecio con descuento: " 
                    + getPrecioDescuento() + "€" : "");
    }

    /**
     * Devuelve una representación simplificada del Vino,
     * útil para listados breves o vistas resumidas.
     *
     * @return Cadena con información básica del vino.
     */
    @Override
    public String toSimpleString() {
        return "Vino - Marca: " + getMarca() + " - Tipo de vino: " + tipoVino + "- Precio: " + getPrecio() + "€";
    }
}
