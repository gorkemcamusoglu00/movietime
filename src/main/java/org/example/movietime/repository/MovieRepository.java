package org.example.movietime.repository;

import org.example.movietime.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findByGenre(String genre);

    List<Movie> findByTitleContainingIgnoreCase(String title);

    List<Movie> findTop5ByOrderByRatingDesc();
}