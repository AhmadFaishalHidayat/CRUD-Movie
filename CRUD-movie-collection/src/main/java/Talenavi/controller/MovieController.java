package Talenavi.controller;

import Talenavi.model.Movie;
import Talenavi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/search")
    public List<Movie> searchMovies(@RequestParam String title) {
        return movieService.searchMoviesByTitle(title);
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.createMovie(movie);
    }

    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        return movieService.updateMovie(id, movie);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }
}