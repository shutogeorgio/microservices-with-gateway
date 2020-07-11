package reactive.webflux.service.c.webfluxservicec.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactive.webflux.service.c.webfluxservicec.model.Comment;
import reactive.webflux.service.c.webfluxservicec.repository.CommentRepository;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class CommentHandler {

    public CommentRepository commentRepository;

    CommentHandler(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Mono<ServerResponse> search(ServerRequest req) {
        return req.bodyToMono(Comment.class).map(reqBody ->
                commentRepository.findAllByPostId(reqBody.getPostId()))
                        .flatMap(comment ->
                        ok().contentType(MediaType.APPLICATION_JSON).body(comment, Comment.class));
    }

    public Mono<ServerResponse> getOne(ServerRequest req) {
        int commentId = Integer.parseInt(req.pathVariable("id"));
        return commentRepository.findById(commentId)
                .flatMap(comment ->
                        ok().contentType(MediaType.APPLICATION_JSON).body(comment, Comment.class));
    }

    public Mono<ServerResponse> create(ServerRequest req) {
        return req.bodyToMono(Comment.class).map(reqBody ->
                commentRepository.save(reqBody))
                .flatMap(comment ->
                        ok().contentType(MediaType.APPLICATION_JSON).body(comment, Comment.class));
    }
}
