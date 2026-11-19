package ee.taltech.icd0011.anime_guesser.model;


import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("openings")
public class Opening {

    @Id
    private Long id;
    private String url;
}
