package co.com.sofka.ElParche.ValueObjects;

public class Descripcion {
    private String valor;

    public Descripcion(String valor){
        if(Boolean.FALSE.equals(validar(valor))){
            throw new IllegalArgumentException("La descripcion debe tener entre 10 y 200 caracteres");
        }
        this.valor = valor;
    }

    private Boolean validar(String valor){
        return valor.length() > 10 && valor.length() < 200;
    }

}
