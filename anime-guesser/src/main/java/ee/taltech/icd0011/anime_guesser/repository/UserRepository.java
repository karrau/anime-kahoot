package ee.taltech.icd0011.anime_guesser.repository;

import ee.taltech.icd0011.anime_guesser.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

}
