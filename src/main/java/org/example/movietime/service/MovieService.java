package org.example.movietime.service;

import org.example.movietime.dto.MovieRequest;
import org.example.movietime.entity.Movie;
import org.example.movietime.repository.MovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    @Transactional
    public Movie createMovie(MovieRequest movieRequest) {

        Movie movie = new Movie();

        movie.setTitle(movieRequest.getTitle());
        movie.setDescription(movieRequest.getDescription());
        movie.setGenre(movieRequest.getGenre());
        movie.setReleaseYear(movieRequest.getReleaseYear());
        movie.setRating(movieRequest.getRating());

        return movieRepository.save(movie);
    }

    @Transactional
    public Movie updateMovie(Long id, MovieRequest movieRequest) {

        Optional<Movie> optionalMovie = movieRepository.findById(id);

        if (optionalMovie.isPresent()) {
            Movie existingMovie = optionalMovie.get();

            existingMovie.setTitle(movieRequest.getTitle());
            existingMovie.setDescription(movieRequest.getDescription());
            existingMovie.setGenre(movieRequest.getGenre());
            existingMovie.setReleaseYear(movieRequest.getReleaseYear());
            existingMovie.setRating(movieRequest.getRating());

            return movieRepository.save(existingMovie);
        }

        return null;
    }

    @Transactional
    public boolean deleteMovie(Long id) {

        Optional<Movie> optionalMovie = movieRepository.findById(id);

        if (optionalMovie.isPresent()) {
            movieRepository.deleteById(id);
            return true;
        }

        return false;
    }

    public List<Movie> searchMoviesByTitle(String title) {
        return movieRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Movie> getMoviesByGenre(String genre) {
        return movieRepository.findByGenre(genre);
    }

    public List<Movie> getTopRatedMovies() {
        return movieRepository.findTop5ByOrderByRatingDesc();
    }
}
