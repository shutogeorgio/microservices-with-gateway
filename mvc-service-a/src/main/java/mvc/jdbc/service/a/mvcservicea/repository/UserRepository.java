package mvc.jdbc.service.a.mvcservicea.repository;

import mvc.jdbc.service.a.mvcservicea.model.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@Configuration
public interface UserRepository extends JpaRepository<User, UUID> {

}
