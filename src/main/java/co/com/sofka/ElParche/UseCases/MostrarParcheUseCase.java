package co.com.sofka.ElParche.UseCases;

import co.com.sofka.ElParche.DTO.ComentarioDTO;
import co.com.sofka.ElParche.DTO.ParcheDTO;
import co.com.sofka.ElParche.Mappers.ComentarioMapper;
import co.com.sofka.ElParche.Mappers.ParcheMapper;
import co.com.sofka.ElParche.Mappers.UsuarioMapper;
import co.com.sofka.ElParche.Repositories.ComentarioRepository;
import co.com.sofka.ElParche.Repositories.ParcheRepository;
import co.com.sofka.ElParche.Repositories.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.function.Function;

@Service
@Validated
public class MostrarParcheUseCase implements Function<String, Mono<ParcheDTO>> {
    private final ComentarioMapper comentarioMapper;
    private final ParcheMapper parcheMapper;
    private final UsuarioMapper usuarioMapper;
    private final ComentarioRepository comentarioRepository;
    private final ParcheRepository parcheRepository;
    private final UsuarioRepository usuarioRepository;

    public MostrarParcheUseCase(ComentarioMapper comentarioMapper, ParcheMapper parcheMapper, UsuarioMapper usuarioMapper, ComentarioRepository comentarioRepository, ParcheRepository parcheRepository, UsuarioRepository usuarioRepository) {
        this.comentarioMapper = comentarioMapper;
        this.parcheMapper = parcheMapper;
        this.usuarioMapper = usuarioMapper;
        this.comentarioRepository = comentarioRepository;
        this.parcheRepository = parcheRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Mono<ParcheDTO> apply(String idParche) {
        Objects.requireNonNull(idParche,"Id Requerido");
        return parcheRepository.findById(idParche)
                .map(parcheMapper.mapToDTO())
                .flatMap(getParcheDTOMonoFunction());
    }

    private Function<ParcheDTO, Mono<ParcheDTO>> getParcheDTOMonoFunction() {
        return parcheDTO -> Mono.just(parcheDTO)
                .zipWith(
                        comentarioRepository.findByParcheId(parcheDTO.getId())
                                .map(comentarioMapper.comentariomapToDTO())
                                .flatMap(getUsuario())
                                .collectList(),
                        (parche, comentario) -> {
                            parche.setComentarios(comentario);
                            return parche;
                        }
                );
    }

    private Function<ComentarioDTO, Mono<ComentarioDTO>> getUsuario() {
        return comentarioDTO -> Mono.just(comentarioDTO)
                .zipWith(
                        usuarioRepository.findById(comentarioDTO.getUserId())
                                .map(usuarioMapper.usuariomapToDTO()),
                        (comentario, usuario) -> {
                            comentario.setUsuario(usuario);
                            return comentario;
                        }
                );
    }
}
