package co.com.sofka.ElParche.ValueObjects;

public class Capacidad {

    private final Long valor;

    public Capacidad(Long capacidad){
        if (Boolean.FALSE.equals(validar(capacidad))){
            throw new IllegalArgumentException("La capacidad no puede ser negativa");
        }
        this.valor = capacidad;
    }

    private Boolean validar(Long capacidad){
        return capacidad > 0;
    }

    public Long getValor(){
        return valor;
    }

}
