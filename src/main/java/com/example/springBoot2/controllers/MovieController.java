package com.example.springBoot2.controllers;

import com.example.springBoot2.models.Movie;
import com.example.springBoot2.repositories.MovieRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    //Get all items
    @GetMapping
    public List<Movie> getAllItems() {
        return movieRepository.findAll();
    }

    // Get single item by id
    @GetMapping("/{id}")
    public Movie getItem(@PathVariable int id) {
        return movieRepository.findById(id).orElse(null);
    }

    // add an item
    @PostMapping
    public Movie addItem(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }
    // update an item
    @PutMapping("/{id}")
    public Movie updateItem(@PathVariable int id, @RequestBody Movie movie) {
        movie.setId(id);
        return movieRepository.save(movie);
    }

    // delete an item
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable int id) {
        movieRepository.deleteById(id);
    }
}