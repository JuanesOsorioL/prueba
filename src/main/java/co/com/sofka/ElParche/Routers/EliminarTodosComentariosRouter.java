package co.com.sofka.ElParche.Routers;

import co.com.sofka.ElParche.UseCases.comentario.EliminarTodosComentariosUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class EliminarTodosComentariosRouter {

    @Bean
    public RouterFunction<ServerResponse> delete(EliminarTodosComentariosUseCase eliminarTodosComentariosUseCase) {
        return route(
                DELETE("/delete/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.accepted()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(eliminarTodosComentariosUseCase.apply(request.pathVariable("id")), Void.class))
        );
    }
}
