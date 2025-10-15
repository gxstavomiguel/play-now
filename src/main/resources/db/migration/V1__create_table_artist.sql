CREATE TABLE artist (
                        id BIGSERIAL PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        country VARCHAR(255),
                        description VARCHAR(1000),
                        image_url VARCHAR(255)
);
