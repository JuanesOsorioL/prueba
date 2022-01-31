package co.com.sofka.ElParche.Mappers;

import co.com.sofka.ElParche.Collections.Comentario;
import co.com.sofka.ElParche.DTO.ComentarioDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ComentarioMapper {

    public Function<Comentario, ComentarioDTO> comentariomapToDTO(){
        return comentario -> new ComentarioDTO(
                comentario.getId(),
                comentario.getUserId(),
                comentario.getParcheId(),
                comentario.getComentario(),
                comentario.getFechaCreacio());
    }

    public Function<ComentarioDTO, Comentario> comentariomapToCollection(){
        return ComentarioDTO -> {
            Comentario comentario = new Comentario();
            comentario.setId(ComentarioDTO.getId());
            comentario.setUserId(ComentarioDTO.getUserId());
            comentario.setParcheId(ComentarioDTO.getParcheId());
            comentario.setComentario(ComentarioDTO.getComentario());
            comentario.setFechaCreacio(ComentarioDTO.getFechaCreacio());
            return comentario;
        };
    }
}
