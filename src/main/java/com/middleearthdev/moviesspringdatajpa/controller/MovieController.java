package com.middleearthdev.moviesspringdatajpa.controller;

import com.middleearthdev.moviesspringdatajpa.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/movies")
    ResponseEntity<?> getAllMovies() {
        return  movieService.getAllMovies();
    }

    @GetMapping("/actors")
    ResponseEntity<?> getAllActors() {
        return movieService.getAllActor();
    }

}
