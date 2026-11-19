package ee.taltech.icd0011.anime_guesser.service;

import ee.taltech.icd0011.anime_guesser.dto.UserRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RegistrationService {
    private final UserDetailsManager userDetailsManager;
    private final PasswordEncoder passwordEncoder;

    public RegistrationService(UserDetailsManager userDetailsManager, PasswordEncoder passwordEncoder) {
        this.userDetailsManager = userDetailsManager;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(UserRequest req) {
        if (userDetailsManager.userExists(req.username())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username already exists");
        }

        var user = org.springframework.security.core.userdetails.User
                .withUsername(req.username())
                .password(passwordEncoder.encode(req.password()))
                .roles("USER") // becomes ROLE_USER
                .build();

        userDetailsManager.createUser(user);
    }
}
