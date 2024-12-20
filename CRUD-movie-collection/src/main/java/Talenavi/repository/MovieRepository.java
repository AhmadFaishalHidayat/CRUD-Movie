package Talenavi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Talenavi.model.Movie;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByTitleContaining(String title);
}
