package ee.taltech.icd0011.anime_guesser.model;


import jakarta.validation.constraints.NotBlank;
import org.springframework.data.relational.core.mapping.Table;

@Table("opening")
public class Opening {

    private Long id;
    private long animeId;

    private String url;
}
