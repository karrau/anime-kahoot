package ee.taltech.icd0011.anime_guesser.controller;


import ee.taltech.icd0011.anime_guesser.dto.AuthResponse;
import ee.taltech.icd0011.anime_guesser.dto.UserRequest;
import ee.taltech.icd0011.anime_guesser.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private final AuthService authService;

    public UserController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody @Valid UserRequest userRequest) {
        return authService.register(userRequest);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid UserRequest userRequest) {
        return authService.verify(userRequest);
    }
}
