package ee.taltech.icd0011.anime_guesser.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
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
@Table("round_answer")
public class RoundAnswer {

    @Id
    private Long id;

    @NotNull
    @Column("round_id")
    private Long roundId;

    @NotNull
    @Column("user_id")
    private Long userId;

    @NotBlank
    @Size(max = 255)
    @Column("answer_text")
    private String answerText;

    @NotNull
    @Column("is_correct")
    private Boolean isCorrect;

    @NotNull
    @Column("submitted_at")
    private LocalDateTime submittedAt;

    @NotNull
    @PositiveOrZero
    @Column("awarded_points")
    private Integer awardedPoints;
}
