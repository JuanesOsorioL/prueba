package co.com.sofka.ElParche.UseCases.comentario;

import co.com.sofka.ElParche.Collections.Comentario;
import co.com.sofka.ElParche.DTO.ComentarioDTO;
import co.com.sofka.ElParche.Mappers.ComentarioMapper;
import co.com.sofka.ElParche.Repositories.ComentarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class CrearComentarioUseCase implements CreateComentario {

    private final ComentarioMapper comentarioMapper;
    private final ComentarioRepository comentarioRepository;

    public CrearComentarioUseCase(ComentarioMapper comentarioMapper, ComentarioRepository comentarioRepository) {
        this.comentarioMapper = comentarioMapper;
        this.comentarioRepository = comentarioRepository;
    }

    @Override
    public Mono<Comentario> apply(ComentarioDTO comentarioDTO) {
        return comentarioRepository.save(comentarioMapper.comentariomapToCollection().apply(comentarioDTO))
                .map(comentario -> comentario);
    }
}
