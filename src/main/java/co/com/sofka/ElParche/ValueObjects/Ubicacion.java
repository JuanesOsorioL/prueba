package co.com.sofka.ElParche.ValueObjects;

public class Ubicacion {

    private final Double latitud;
    private final Double longitud;

    public Ubicacion(Double latitud, Double longitud){
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Double getLatitud() {
        return latitud;
    }

    public Double getLongitud() {
        return longitud;
    }
}
