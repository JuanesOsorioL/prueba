package co.com.sofka.ElParche.DTO;

public class UsuarioDTO {
    private String id;
    private String nombre;
    private String path;

    public UsuarioDTO(String id, String nombre, String path) {
        this.id=id;
        this.nombre=nombre;
        this.path=path;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
