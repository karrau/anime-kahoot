package ee.taltech.icd0011.anime_guesser.dto;

import java.time.Instant;

public record ErrorResponse(int status, String error, Instant timestamp) {

    public ErrorResponse(int status, String error) {
        this(status, error, Instant.now());
    }
}
