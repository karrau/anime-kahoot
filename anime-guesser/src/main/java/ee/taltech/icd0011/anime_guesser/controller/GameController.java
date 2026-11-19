package ee.taltech.icd0011.anime_guesser.controller;


import ee.taltech.icd0011.anime_guesser.dto.CreateGameRequest;
import ee.taltech.icd0011.anime_guesser.dto.CreateGameResponse;
import ee.taltech.icd0011.anime_guesser.model.Game;
import ee.taltech.icd0011.anime_guesser.service.CreateGameService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/game")
public class GameController {

    private final CreateGameService createGameService;

    public GameController(CreateGameService createGameService){
        this.createGameService=createGameService;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateGameResponse> createGame(@RequestBody @Valid CreateGameRequest createGameRequest) {
        return createGameService.registerGame(createGameRequest);
    }

    @PostMapping("/join")
    public String welcome() {
        return "Welcome, this is a secured endpoint!";
    }



}
