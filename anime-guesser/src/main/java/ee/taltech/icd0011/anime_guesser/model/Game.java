package ee.taltech.icd0011.anime_guesser.model;


import ee.taltech.icd0011.anime_guesser.constants.GameState;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("game")
public class Game {

    @Id
    private Long id;

    private GameState gameState;

    @NotNull
    private Long hostId;

    @NotNull
    @Pattern(regexp = "^\\d{4}$")
    private String gameCode;

    @Positive
    private int maxPlayers;


    private LocalDateTime createdAt;
    private LocalDateTime startedAt;
    private LocalDateTime finishedAt;

    private Set<Integer> animes = new HashSet<>();


}
