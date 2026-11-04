package ee.taltech.icd0011.anime_guesser.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/game")
public class GameController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome, this is a secured endpoint!";
    }

}
