package co.com.sofka.ElParche.UseCases.comentario;

import co.com.sofka.ElParche.DTO.ComentarioDTO;
import co.com.sofka.ElParche.Mappers.ComentarioMapper;
import co.com.sofka.ElParche.Repositories.ComentarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
@Validated
public class MostrarComentarioUseCase implements Supplier<Flux<ComentarioDTO>> {
    private final ComentarioMapper comentarioMapper;
    private final ComentarioRepository comentarioRepository;

    public MostrarComentarioUseCase(ComentarioMapper comentarioMapper, ComentarioRepository comentarioRepository) {
        this.comentarioMapper = comentarioMapper;
        this.comentarioRepository = comentarioRepository;
    }

    @Override
    public Flux<ComentarioDTO> get() {
        return comentarioRepository.findAll().map(comentarioMapper.comentariomapToDTO());
    }
}
