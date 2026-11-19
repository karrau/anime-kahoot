package ee.taltech.icd0011.anime_guesser.dto;

import java.util.HashSet;
import java.util.Set;

public record CreateGameRequest(
        Integer maxPlayers,
        Set<Integer> animeIds

) {



}
