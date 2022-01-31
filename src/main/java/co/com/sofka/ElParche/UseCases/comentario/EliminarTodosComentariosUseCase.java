package co.com.sofka.ElParche.UseCases.comentario;

import co.com.sofka.ElParche.Mappers.ComentarioMapper;
import co.com.sofka.ElParche.Repositories.ComentarioRepository;
import co.com.sofka.ElParche.Repositories.ParcheRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.function.Function;

@Service
@Validated
public class EliminarTodosComentariosUseCase implements Function<String, Mono<Void>> {
    private final ParcheRepository parcheRepository;
    private final ComentarioRepository comentarioRepository;

    public EliminarTodosComentariosUseCase( ParcheRepository parcheRepository, ComentarioRepository comentarioRepository) {
        this.parcheRepository = parcheRepository;
        this.comentarioRepository = comentarioRepository;
    }

    @Override
    public Mono<Void> apply(String idParche) {
        Objects.requireNonNull(idParche, "Id pregunta requerida");
        /*return parcheRepository.deleteById(idParche)
                .switchIfEmpty(Mono.defer(() -> comentarioRepository.deleteByParcheId(idParche)));*/
        return comentarioRepository.deleteByParcheId(idParche);
    }

}
