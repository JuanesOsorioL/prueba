package co.com.sofka.ElParche.DTO;


import co.com.sofka.ElParche.ValueObjects.Nombre;

import java.util.List;

public class ParcheDTO {

    private String id;
    private String nombreParche;
    private List<ComentarioDTO> comentarios;

    public ParcheDTO(){
    }

    public ParcheDTO(String id, String duenoDelParche) {
        this.id = id;
        this.nombreParche = duenoDelParche;
    }

    public ParcheDTO(String id, String nombreParche, List<ComentarioDTO> comentarios) {
        this.id = id;
        this.nombreParche = nombreParche;
        this.comentarios = comentarios;
    }

    public ParcheDTO(String id, Nombre nombreParche) {

    }

    public List<ComentarioDTO> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<ComentarioDTO> comentarios) {
        this.comentarios = comentarios;
    }

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
