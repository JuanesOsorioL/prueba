package co.com.sofka.ElParche.Mappers;

import co.com.sofka.ElParche.Collections.Usuario;
import co.com.sofka.ElParche.DTO.UsuarioDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UsuarioMapper {

    public Function<Usuario, UsuarioDTO> usuariomapToDTO(){
        return usuario -> new UsuarioDTO(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getPath());
    }

    public Function<UsuarioDTO, Usuario> usuariomapToCollection(){
        return usuarioDTO -> {
            Usuario usuario = new Usuario();
            usuario.setId(usuarioDTO.getId());
            usuario.setNombre(usuarioDTO.getNombre());
            usuario.setPath(usuarioDTO.getPath());
            return usuario;
        };
    }

}
