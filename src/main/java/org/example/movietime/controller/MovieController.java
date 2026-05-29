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

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Movie> createMovie(@Valid @RequestBody MovieRequest movieRequest) {
        Movie createdMovie = movieService.createMovie(movieRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMovie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(
            @PathVariable Long id,
            @Valid @RequestBody MovieRequest movieRequest) {

        Movie updatedMovie = movieService.updateMovie(id, movieRequest);

        if (updatedMovie != null) {
            return ResponseEntity.ok(updatedMovie);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable Long id) {

        boolean deleted = movieService.deleteMovie(id);

        if (deleted) {
            return ResponseEntity.ok("Film silindi.");
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Movie>> searchMoviesByTitle(@RequestParam String title) {
        return ResponseEntity.ok(movieService.searchMoviesByTitle(title));
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<Movie>> getMoviesByGenre(@PathVariable String genre) {
        return ResponseEntity.ok(movieService.getMoviesByGenre(genre));
    }

    @GetMapping("/top-rated")
    public ResponseEntity<List<Movie>> getTopRatedMovies() {
        return ResponseEntity.ok(movieService.getTopRatedMovies());
    }
}
