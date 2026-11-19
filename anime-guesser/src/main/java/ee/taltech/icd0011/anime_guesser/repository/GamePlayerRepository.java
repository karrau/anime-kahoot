package ee.taltech.icd0011.anime_guesser.repository;

import ee.taltech.icd0011.anime_guesser.model.GamePlayer;
import org.springframework.data.repository.CrudRepository;

public interface GamePlayerRepository extends CrudRepository<GamePlayer, Long> {
}
