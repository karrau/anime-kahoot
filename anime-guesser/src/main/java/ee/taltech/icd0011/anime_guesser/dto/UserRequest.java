package ee.taltech.icd0011.anime_guesser.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequest (
        @NotBlank
        @Size(min = 2, max = 20)
        String username,

        @NotBlank
        @Size(min = 4, max = 20)
        String password
){

}
