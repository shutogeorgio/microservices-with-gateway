package reactive.webflux.service.c.webfluxservicec.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactive.webflux.service.c.webfluxservicec.handler.CommentHandler;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class CommentRouter {

    @Bean
    public RouterFunction<ServerResponse> route(CommentHandler handler) {
        return RouterFunctions
                .route(GET("/comment").and(contentType(APPLICATION_JSON)), handler::search)
                        .andRoute(GET("/comment/{id}").and(contentType(APPLICATION_JSON)), handler::getOne)
                        .andRoute(POST("/comment").and(contentType(APPLICATION_JSON)), handler::create);
    }
}
