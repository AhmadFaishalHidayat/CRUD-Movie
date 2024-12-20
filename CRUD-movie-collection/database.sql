CREATE TABLE movie (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    director VARCHAR(255) NOT NULL,
    summary VARCHAR(100) NOT NULL
);

CREATE TABLE genre (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE
);

INSERT INTO
    genre (name)
VALUES ('Drama'),
    ('Action'),
    ('Animation'),
    ('Sci-Fi'),
    ('Horror');

CREATE TABLE movie_collection (
    movie_id INT NOT NULL,
    genre_id INT NOT NULL,
    PRIMARY KEY (movie_id, genre_id),
    FOREIGN KEY (movie_id) REFERENCES movie (id) ON DELETE CASCADE,
    FOREIGN KEY (genre_id) REFERENCES genre (id) ON DELETE CASCADE
);

DROP TABLE IF EXISTS movie_collection;

DROP TABLE IF EXISTS movie;

DROP TABLE IF EXISTS genre;