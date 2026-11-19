package ee.taltech.icd0011.anime_guesser.dto;

import ee.taltech.icd0011.anime_guesser.constants.GameState;

import java.util.Set;

public record CreateGameResponse(
        Integer maxPlayers,
        Integer roundCount,
        String gameCode,
        GameState state


) {

}
