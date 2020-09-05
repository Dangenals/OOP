package com.project.cinema.services;

import com.project.cinema.model.Customer;
import com.project.cinema.model.Movie;
import com.project.cinema.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return (List<Movie>) movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(int id) {
        return movieRepository.findById(id);
    }

    public void deleteMovieById(int id) {
        movieRepository.deleteById(id);
    }

    public void createMovie(Movie movie) {
    }
}
