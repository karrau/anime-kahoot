package ee.taltech.icd0011.anime_guesser.service;

import ee.taltech.icd0011.anime_guesser.constants.GameState;
import ee.taltech.icd0011.anime_guesser.dto.CreateGameRequest;
import ee.taltech.icd0011.anime_guesser.dto.CreateGameResponse;
import ee.taltech.icd0011.anime_guesser.dto.UserRequest;
import ee.taltech.icd0011.anime_guesser.dto.UserResponse;
import ee.taltech.icd0011.anime_guesser.model.Game;
import ee.taltech.icd0011.anime_guesser.repository.AnimeRepository;
import ee.taltech.icd0011.anime_guesser.repository.GameRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class CreateGameService {

    private final GameRepository gameRepository;
    private final AnimeRepository animeRepository;

    public CreateGameService(GameRepository gameRepository,  AnimeRepository animeRepository) {
        this.gameRepository = gameRepository;
        this.animeRepository = animeRepository;
    }

    public ResponseEntity<CreateGameResponse> registerGame(CreateGameRequest createGameRequest) {
        CreateGameResponse createdGame = createGame(createGameRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdGame);
    }

    public CreateGameResponse createGame(@RequestBody @Valid CreateGameRequest createGameRequest) {
        Game game = new Game();
        game.setAnimes(createGameRequest.animeIds());
        game.setMaxPlayers(createGameRequest.maxPlayers());

        Game savedGame = gameRepository.save(game);


        return new CreateGameResponse(savedGame.getMaxPlayers(), savedGame.getAnimes().size(), createGameCode(), GameState.LOBBY);
    }

    public String createGameCode() {
        return String.valueOf(ThreadLocalRandom.current().nextInt(1000, 10000));
    }
}
