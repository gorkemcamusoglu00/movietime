package org.example.movietime.entity;

import jakarta.persistence.*;

@Entity
public class movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String genre;

    private Integer releaseYear;

    private Double rating;

    public movie() {
    }

    public movie(Long id, String title, String description,
                 String genre, Integer releaseYear, Double rating) {

        this.id = id;
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

    public Long getId() {
        return id;
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