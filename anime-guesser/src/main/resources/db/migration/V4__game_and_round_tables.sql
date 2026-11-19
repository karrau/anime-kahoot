CREATE TABLE game (
                     id BIGSERIAL PRIMARY KEY,
                     host_id BIGINT NOT NULL,
                     game_code VARCHAR(4) NOT NULL,
                     game_state VARCHAR(20) NOT NULL,
                     max_players INTEGER NOT NULL CHECK (max_players > 0),
                     created_at TIMESTAMP NOT NULL DEFAULT NOW(),
                     started_at TIMESTAMP NULL,
                     finished_at TIMESTAMP NULL,
                     CONSTRAINT fk_game_host FOREIGN KEY (host_id) REFERENCES users(id),
                     CONSTRAINT uq_game_code UNIQUE (game_code),
                     CONSTRAINT chk_game_code_digits CHECK (game_code ~ '^[0-9]{4}$'),
                     CONSTRAINT chk_game_state CHECK (game_state IN ('LOBBY', 'IN_PROGRESS', 'FINISHED'))
);

CREATE TABLE game_player (
                            id BIGSERIAL PRIMARY KEY,
                            game_id BIGINT NOT NULL,
                            user_id BIGINT NOT NULL,
                            score INTEGER NOT NULL DEFAULT 0 CHECK (score >= 0),
                            joined_at TIMESTAMP NOT NULL DEFAULT NOW(),
                            CONSTRAINT fk_game_player_game FOREIGN KEY (game_id) REFERENCES game(id) ON DELETE CASCADE,
                            CONSTRAINT fk_game_player_user FOREIGN KEY (user_id) REFERENCES users(id),
                            CONSTRAINT uq_game_player UNIQUE (game_id, user_id)
);

CREATE TABLE round (
                      id BIGSERIAL PRIMARY KEY,
                      game_id BIGINT NOT NULL,
                      round_number INTEGER NOT NULL CHECK (round_number > 0),
                      anime_id BIGINT NOT NULL,
                      opening_id BIGINT NOT NULL,
                      points INTEGER NOT NULL CHECK (points >= 0),
                      duration_sec INTEGER NOT NULL CHECK (duration_sec > 0),
                      status VARCHAR(20) NOT NULL,
                      started_at TIMESTAMP NULL,
                      ended_at TIMESTAMP NULL,
                      CONSTRAINT fk_round_game FOREIGN KEY (game_id) REFERENCES game(id) ON DELETE CASCADE,
                      CONSTRAINT fk_round_anime FOREIGN KEY (anime_id) REFERENCES anime(id),
                      CONSTRAINT fk_round_opening FOREIGN KEY (opening_id) REFERENCES opening(id),
                      CONSTRAINT uq_round_game_round_number UNIQUE (game_id, round_number),
                      CONSTRAINT chk_round_status CHECK (status IN ('PENDING', 'ACTIVE', 'CLOSED'))
);

CREATE TABLE round_answer (
                             id BIGSERIAL PRIMARY KEY,
                             round_id BIGINT NOT NULL,
                             user_id BIGINT NOT NULL,
                             answer_text VARCHAR(255) NOT NULL,
                             is_correct BOOLEAN NOT NULL,
                             submitted_at TIMESTAMP NOT NULL DEFAULT NOW(),
                             awarded_points INTEGER NOT NULL DEFAULT 0 CHECK (awarded_points >= 0),
                             CONSTRAINT fk_round_answer_round FOREIGN KEY (round_id) REFERENCES round(id) ON DELETE CASCADE,
                             CONSTRAINT fk_round_answer_user FOREIGN KEY (user_id) REFERENCES users(id),
                             CONSTRAINT uq_round_answer_user UNIQUE (round_id, user_id)
);

CREATE INDEX ix_game_state_code ON game(game_state, game_code);
CREATE INDEX ix_game_player_game ON game_player(game_id);
CREATE INDEX ix_round_game ON round(game_id);
CREATE INDEX ix_round_answer_round ON round_answer(round_id);
