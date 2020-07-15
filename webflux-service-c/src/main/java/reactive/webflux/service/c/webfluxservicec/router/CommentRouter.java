package reactive.webflux.service.c.webfluxservicec.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactive.webflux.service.c.webfluxservicec.handler.CommentHandler;

@Configuration
public class CommentRouter {

    @Bean
    RouterFunction<ServerResponse> videosRoutes(CommentHandler handler) {
        return handler.routes();
    }
}
