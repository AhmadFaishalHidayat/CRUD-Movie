package Talenavi.service;

import java.util.List;
import java.util.Optional;

import Talenavi.model.Movie;

public interface MovieService {
    List<Movie> getAllMovies();

    List<Movie> searchMoviesByTitle(String title);

    Optional<Movie> getMovieById(Long id);

    Movie createMovie(Movie movie);

    Movie updateMovie(Long id, Movie movie);

    void deleteMovie(Long id);
}
