package com.project.cinema.controllers;

import com.project.cinema.model.Customer;
import com.project.cinema.model.Movie;
import com.project.cinema.services.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MovieController {
    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping(path="/movies")
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }

    @GetMapping(path="/movies/{id}")
    public Optional<Movie> getMovieById(@PathVariable int id){
        return movieService.getMovieById(id);
    }

    @DeleteMapping("/movies/{id}")
    public String deleteMovieById(@PathVariable int id) {
        movieService.deleteMovieById(id);
        return "Movie was deleted";
    }

    @PostMapping("/movies")
    public String createMovie(@RequestBody Movie movie){
        movieService.createMovie(movie);
        return "Movie was added";
    }

}
