package webfluxserviceb.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import webfluxserviceb.model.Post;

@Repository
public interface PostRepository extends ReactiveCrudRepository<Post, Long> {
}
