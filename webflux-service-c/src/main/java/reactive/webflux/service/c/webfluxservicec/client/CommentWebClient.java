package reactive.webflux.service.c.webfluxservicec.client;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class CommentWebClient {
    private WebClient client;
    public WebClient webClient(WebClient client) {
        return WebClient.create();
    }
}
