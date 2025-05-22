package com.practica.Productos;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.practica.Interfaces.IAlimento;
import com.practica.Interfaces.IDescuento;
import com.practica.Interfaces.ILiquido;

public class Vino extends Producto implements ILiquido, IAlimento, IDescuento {
    private String tipoVino;
    private float gradosAlcohol;
    private float volumen;
    private String tipoEnvase;
    private Date caducidad;
    private int calorias;
    private float descuento; // Porcentaje de descuento

    public Vino(String marca, float precio, String tipoVino, float gradosAlcohol) {
        super(marca, precio);
        this.tipoVino = tipoVino;
        this.gradosAlcohol = gradosAlcohol;
        calorias = (int) gradosAlcohol * 10;
    }

    public Vino(String marca, float precio, String tipoVino, float gradosAlcohol, float volumen, String tipoEnvase, float descuento) {
        super(marca, precio);
        this.tipoVino = tipoVino;
        this.gradosAlcohol = gradosAlcohol;
        this.volumen = volumen;
        this.tipoEnvase = tipoEnvase;
        this.descuento = descuento;

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

    @Override
    public String toSimpleString() {
        return "Vino - Marca: " + getMarca() + " - Tipo de vino: " + tipoVino + "- Precio: " + getPrecio() + "€";
    }
}
