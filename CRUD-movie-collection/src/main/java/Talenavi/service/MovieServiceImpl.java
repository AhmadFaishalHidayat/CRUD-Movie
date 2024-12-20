package Talenavi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Talenavi.model.Movie;
import Talenavi.repository.MovieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> searchMoviesByTitle(String title) {
        return movieRepository.findByTitleContaining(title);
    }

    @Override
    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    @Override
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie updateMovie(Long id, Movie movieDetails) {
        return movieRepository.findById(id).map(movie -> {
            movie.setTitle(movieDetails.getTitle());
            movie.setDirector(movieDetails.getDirector());
            movie.setSummary(movieDetails.getSummary());
            movie.setGenres(movieDetails.getGenres());
            return movieRepository.save(movie);
        }).orElseThrow(() -> new RuntimeException("Movie not found"));
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}