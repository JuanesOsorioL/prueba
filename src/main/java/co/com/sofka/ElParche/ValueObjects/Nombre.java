package co.com.sofka.ElParche.ValueObjects;

public class Nombre {
    private String valor;

    public Nombre(String valor){
        if(Boolean.FALSE.equals(validar(valor))){
            throw new IllegalArgumentException("El nombre del parche es invalido");
        }
        this.valor = valor;
    }

    private Boolean validar(String valor){
        return valor.length() <= 50 && valor.matches("[a-zA-Z_0-9]");
    }
}
