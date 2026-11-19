package ee.taltech.icd0011.anime_guesser.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("anime")
public class Anime {

    private Long id;

    private String animeName;

    private Opening opening;


}
