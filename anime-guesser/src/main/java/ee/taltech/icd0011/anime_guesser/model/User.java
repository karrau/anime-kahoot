package ee.taltech.icd0011.anime_guesser.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("users")
public class User {

    @Id
    private Long id;

    @NotBlank
    @Size(min = 2, max = 20)
    private String username;

    @NotBlank
    private String password;
}
