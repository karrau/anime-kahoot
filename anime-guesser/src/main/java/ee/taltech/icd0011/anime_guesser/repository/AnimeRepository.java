package ee.taltech.icd0011.anime_guesser.repository;

import ee.taltech.icd0011.anime_guesser.model.Anime;
import org.springframework.data.repository.CrudRepository;

public interface AnimeRepository extends CrudRepository<Anime, Long> {
}
