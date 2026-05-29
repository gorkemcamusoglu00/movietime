package org.example.movietime.service;

import org.example.movietime.dto.MovieRequest;
import org.example.movietime.entity.Movie;
import org.example.movietime.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie createMovie(MovieRequest movieRequest) {

        Movie movie = new Movie();

        movie.setTitle(movieRequest.getTitle());
        movie.setDescription(movieRequest.getDescription());
        movie.setGenre(movieRequest.getGenre());
        movie.setReleaseYear(movieRequest.getReleaseYear());
        movie.setRating(movieRequest.getRating());

        return movieRepository.save(movie);
    }

    public List<Movie> searchMovies(String title) {
        return movieRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Movie> getTopRatedMovies() {
        return movieRepository.findTop5ByOrderByRatingDesc();
    }
}