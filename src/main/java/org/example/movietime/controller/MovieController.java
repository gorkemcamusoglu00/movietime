package org.example.movietime.controller;

import jakarta.validation.Valid;
import org.example.movietime.dto.MovieRequest;
import org.example.movietime.entity.Movie;
import org.example.movietime.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @PostMapping
    public ResponseEntity<Movie> createMovie(@Valid @RequestBody MovieRequest movieRequest) {

        Movie createdMovie = movieService.createMovie(movieRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdMovie);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Movie>> searchMovies(@RequestParam String title) {

        return ResponseEntity.ok(movieService.searchMovies(title));
    }

    @GetMapping("/top-rated")
    public ResponseEntity<List<Movie>> getTopRatedMovies() {

        return ResponseEntity.ok(movieService.getTopRatedMovies());
    }
}