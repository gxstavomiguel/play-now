CREATE TABLE music (
                       id BIGSERIAL PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       artist_id BIGINT NOT NULL,
                       album_id BIGINT,
                       genre_id BIGINT,
                       duration_seconds INT NOT NULL,

                       CONSTRAINT fk_music_artist FOREIGN KEY (artist_id) REFERENCES artist(id),
                       CONSTRAINT fk_music_album FOREIGN KEY (album_id) REFERENCES album(id),
                       CONSTRAINT fk_music_genre FOREIGN KEY (genre_id) REFERENCES genre(id)
)