package webfluxserviceb.repository;

import io.r2dbc.spi.ConnectionFactoryOptions;
import org.springframework.boot.autoconfigure.r2dbc.ConnectionFactoryOptionsBuilderCustomizer;
import org.springframework.context.annotation.Bean;

import java.time.Duration;

public class PostDataConfig {
    @Bean
    public ConnectionFactoryOptionsBuilderCustomizer setConnectTimeout() {
        return builder -> builder.option(ConnectionFactoryOptions.CONNECT_TIMEOUT, Duration.ofSeconds(10));
    }
}
