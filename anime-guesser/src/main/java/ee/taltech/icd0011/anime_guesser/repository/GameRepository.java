package ee.taltech.icd0011.anime_guesser.repository;

import ee.taltech.icd0011.anime_guesser.model.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game,Long> {

}
