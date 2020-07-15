package reactive.webflux.service.c.webfluxservicec.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class CommentWebClient {
    @Bean
    WebClient webClient() {
        return WebClient.builder().build();
    }
}
