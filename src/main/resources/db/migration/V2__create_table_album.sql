CREATE TABLE album (
                       id BIGSERIAL PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       release_year INT,
                       artist_id BIGINT,
                       CONSTRAINT fk_album_artist FOREIGN KEY (artist_id) REFERENCES artist(id)
);
