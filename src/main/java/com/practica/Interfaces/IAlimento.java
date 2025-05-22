package com.practica.Interfaces;

import java.util.Date;

public interface IAlimento {
    void setCaducidad(Date fecha);
    Date getCaducidad();
    int getCalorias();
}
