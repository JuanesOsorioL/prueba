package co.com.sofka.ElParche.Collections;

import co.com.sofka.ElParche.Enums.Categoria;
import co.com.sofka.ElParche.Enums.Estado;
import co.com.sofka.ElParche.ValueObjects.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value="parches")
public class Parche {

    @Id
    private String id;
    private String nombreParche;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreParche() {
        return nombreParche;
    }

    public void setNombreParche(String nombreParche) {
        this.nombreParche = nombreParche;
    }
}
