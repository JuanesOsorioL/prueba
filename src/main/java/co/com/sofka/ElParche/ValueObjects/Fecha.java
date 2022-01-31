package co.com.sofka.ElParche.ValueObjects;

import java.time.LocalDate;

public class Fecha {

    private final LocalDate valorFecha;

    public Fecha(LocalDate fecha){
        this.valorFecha = fecha;
    }

    private Boolean esFechaPosterior(LocalDate fecha){
        return this.valorFecha.isBefore(fecha);
    }
}
