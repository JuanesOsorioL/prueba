package co.com.sofka.ElParche.DTO;

import co.com.sofka.ElParche.Collections.Comentario;
import co.com.sofka.ElParche.Collections.Usuario;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;

public class ComentarioDTO {
    private String id;
    private String userId;
    private String parcheId;
    private String comentario;
    private UsuarioDTO usuario;
    private LocalDateTime fechaCreacio;


    public ComentarioDTO(String id, String userId, String parcheId, String comentario, LocalDateTime fechaCreacio) {
        this.id = id;
        this.userId = userId;
        this.parcheId = parcheId;
        this.comentario = comentario;
        //this.fechaCreacio = fechaCreacio;
        this.fechaCreacio = LocalDateTime.now(ZoneId.of("America/Bogota"));
        //LocalDateTime.now(ZoneId.of("America/Bogota"));

    }

    public ComentarioDTO(String id, String userId, String parcheId, String comentario, UsuarioDTO usuario, LocalDateTime fechaCreacio) {
        this.id = id;
        this.userId = userId;
        this.parcheId = parcheId;
        this.comentario = comentario;
        this.usuario = usuario;
        this.fechaCreacio = fechaCreacio;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getParcheId() {
        return parcheId;
    }

    public void setParcheId(String parcheId) {
        this.parcheId = parcheId;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDateTime getFechaCreacio() {
        return fechaCreacio;
    }

    public void setFechaCreacio(LocalDateTime fechaCreacio) {
        this.fechaCreacio = fechaCreacio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComentarioDTO that = (ComentarioDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(userId, that.userId) && Objects.equals(parcheId, that.parcheId) && Objects.equals(comentario, that.comentario) && Objects.equals(fechaCreacio, that.fechaCreacio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, parcheId, comentario, fechaCreacio);
    }
}
