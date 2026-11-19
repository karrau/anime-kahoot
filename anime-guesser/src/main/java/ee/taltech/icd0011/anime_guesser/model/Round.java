package ee.taltech.icd0011.anime_guesser.model;

import ee.taltech.icd0011.anime_guesser.constants.RoundStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("round")
public class Round {

    @Id
    private Long id;

    @NotNull
    @Column("game_id")
    private Long gameId;

    @NotNull
    @Positive
    @Column("round_number")
    private Integer roundNumber;

    @NotNull
    @Column("anime_id")
    private Long animeId;

    @NotNull
    @Column("opening_id")
    private Long openingId;

    @NotNull
    @PositiveOrZero
    private Integer points;

    @NotNull
    @Positive
    @Column("duration_sec")
    private Integer durationSec;

    @NotNull
    private RoundStatus status;

    @Column("started_at")
    private LocalDateTime startedAt;

    @Column("ended_at")
    private LocalDateTime endedAt;
}
