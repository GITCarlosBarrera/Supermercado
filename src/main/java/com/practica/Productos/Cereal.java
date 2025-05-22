package com.practica.Productos;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

import com.practica.Interfaces.IAlimento;

public class Cereal extends Producto implements IAlimento {
    private String tipoCereal;
    private Date caducidad;
    private int calorias;    

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

    @Override
    public String toSimpleString() {
        return "Cereal - Marca: " + getMarca() + " - Tipo de cereal: " + tipoCereal + "- Precio: " + getPrecio() + "€";
    }
}
