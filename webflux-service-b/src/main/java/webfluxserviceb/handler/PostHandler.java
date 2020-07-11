package webfluxserviceb.handler;

import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import webfluxserviceb.model.Post;
import webfluxserviceb.repository.PostRepository;

import java.time.LocalDateTime;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@RestController
@RequestMapping("/api/v2/post")
public class PostHandler {

    private DatabaseClient databaseClient;

    private PostRepository postRepository;

    PostHandler(DatabaseClient databaseClient, PostRepository postRepository) {
        this.databaseClient = databaseClient;
        this.postRepository = postRepository;
    }

    @GetMapping
    public Flux<Post> getAll() {
        return postRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Post> getOne(@PathVariable long id) {
        return postRepository.findById(id);
    }

    @PostMapping
    public Mono<Post> create(@RequestBody @Validated Post req) {
        return postRepository.save(req);
    }

    @PutMapping("/{id}")
    public Mono<Post> update(@PathVariable long id, @RequestBody @Validated Post req) {
        Mono<Post> previousPost = postRepository.findById(id);
        return previousPost.flatMap(previousObj -> {
            previousObj.setTitle(req.getTitle());
            previousObj.setContent(req.getContent());
            previousObj.setUpdatedDate(LocalDateTime.now());
            return postRepository.save(previousObj);
        });
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable long id) {
        return postRepository.deleteById(id);
    }
}
