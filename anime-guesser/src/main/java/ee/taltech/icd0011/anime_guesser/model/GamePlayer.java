package ee.taltech.icd0011.anime_guesser.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("game_player")
public class GamePlayer {
    private Long gameId;

    private Long userId;

    private Long score;

    private LocalDateTime joinedAt;
}
