package co.com.sofka.ElParche.Routers;

import co.com.sofka.ElParche.DTO.ParcheDTO;
import co.com.sofka.ElParche.UseCases.MostrarParcheUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class MostrarParcheRouter {
    @Bean
    public RouterFunction<ServerResponse> mostrarParche(MostrarParcheUseCase mostrarParcheUseCase){
        return route(
              GET("/mostrarParche/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(mostrarParcheUseCase.apply(
                                        request.pathVariable("id")),
                                ParcheDTO.class
                        ))
        );
    }
}
