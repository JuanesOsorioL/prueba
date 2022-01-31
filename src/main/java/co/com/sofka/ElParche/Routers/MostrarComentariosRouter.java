package co.com.sofka.ElParche.Routers;

import co.com.sofka.ElParche.DTO.ComentarioDTO;
import co.com.sofka.ElParche.UseCases.comentario.MostrarComentarioUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class MostrarComentariosRouter {

    @Bean
    public RouterFunction<ServerResponse> mostrarComentario(MostrarComentarioUseCase mostrarComentarioUseCase) {
        return route(GET("/mostrarComentarios"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(mostrarComentarioUseCase.get(), ComentarioDTO.class))
        );
    }
}
