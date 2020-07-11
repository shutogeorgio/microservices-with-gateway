package reactive.webflux.service.c.webfluxservicec.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactive.webflux.service.c.webfluxservicec.model.Comment;
import reactor.core.publisher.Flux;

@Repository
public interface CommentRepository extends ReactiveMongoRepository<Comment, Integer> {

    @Query("select * from comments where postId=?")
    Flux<Comment> findAllByPostId(int postId);
}
