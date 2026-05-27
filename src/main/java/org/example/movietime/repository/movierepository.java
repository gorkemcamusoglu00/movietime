package org.example.movietime.repository;

import org.example.movietime.entity.movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface movierepository extends JpaRepository<movie, Long> {

    List<movie> findByGenre(String genre);

    List<movie> findByTitleContainingIgnoreCase(String title);

    List<movie> findTop5ByOrderByRatingDesc();
}