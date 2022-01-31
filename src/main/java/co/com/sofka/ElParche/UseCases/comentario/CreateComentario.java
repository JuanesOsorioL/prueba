package co.com.sofka.ElParche.UseCases.comentario;

import co.com.sofka.ElParche.Collections.Comentario;
import co.com.sofka.ElParche.DTO.ComentarioDTO;
import reactor.core.publisher.Mono;

public interface CreateComentario {
    Mono<Comentario> apply(ComentarioDTO comentarioDTO);
}
