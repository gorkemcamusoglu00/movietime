package org.example.movietime.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class MovieRequest {

    @NotBlank(message = "Title cannot be empty")
    @Size(min = 2, max = 100)
    private String title;

    @NotBlank(message = "Description cannot be empty")
    @Size(min = 10, max = 500)
    private String description;

    @NotBlank(message = "Genre cannot be empty")
    private String genre;

    @Min(value = 1900, message = "Release year must be after 1900")
    @Max(value = 2026, message = "Release year is invalid")
    private Integer releaseYear;

    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 10, message = "Rating cannot be greater than 10")
    private Double rating;

    public MovieRequest() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}