package ee.taltech.icd0011.anime_guesser.service;

import ee.taltech.icd0011.anime_guesser.dto.AuthResponse;
import ee.taltech.icd0011.anime_guesser.dto.UserRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;
    private final UserService userService;

    public AuthService(AuthenticationManager authenticationManager, JWTService jwtService, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userService = userService;
    }

    public ResponseEntity<AuthResponse> register(UserRequest userRequest) {
        userService.register(userRequest);
        String token = jwtService.generateToken(userRequest.username());
        return ResponseEntity.status(HttpStatus.CREATED).body(new AuthResponse(token));
    }

    public ResponseEntity<AuthResponse> verify(UserRequest userRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userRequest.username(),
                            userRequest.password()
                    )
            );
        } catch (AuthenticationException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid username or password");
        }

        String token = jwtService.generateToken(userRequest.username());
        return ResponseEntity.ok(new AuthResponse(token));
    }
}
