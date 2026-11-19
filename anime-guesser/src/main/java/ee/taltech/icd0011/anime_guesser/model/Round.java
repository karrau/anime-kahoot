package ee.taltech.icd0011.anime_guesser.model;

import org.springframework.data.annotation.Id;

public class Round {

    @Id
    private Long Id;

    private Long gameId;

    private Long roundNumber;

    private Anime anime;

    private Long points;




}
