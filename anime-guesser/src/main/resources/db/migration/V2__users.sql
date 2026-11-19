CREATE TABLE users (
                       id BIGSERIAL PRIMARY KEY,
                       username VARCHAR(50) NOT NULL UNIQUE,
                       password VARCHAR(500) NOT NULL,
                       enabled BOOLEAN NOT NULL
);

CREATE TABLE authorities (
                             id BIGSERIAL PRIMARY KEY,
                             user_id BIGINT NOT NULL,
                             authority VARCHAR(50) NOT NULL,
                             FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
                             CONSTRAINT uq_authorities_user_role UNIQUE (user_id, authority)
);
