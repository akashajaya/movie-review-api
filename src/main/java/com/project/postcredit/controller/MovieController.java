package com.project.postcredit.controller;

import com.project.postcredit.model.Movie;
import com.project.postcredit.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movie")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("add")
    public ResponseEntity<String> addMovies(@RequestBody Movie movie){
        return movieService.addMovie(movie);
    }

    @GetMapping("get/genre/{genre}")
    public ResponseEntity<List<Movie>> getMoviesByGenre(@PathVariable String genre){
        return movieService.getMoviesByGenre(genre);
    }

    @GetMapping("get/lang/{language}")
    public ResponseEntity<List<Movie>> getMoviesByLanguage(@PathVariable String language){
        return movieService.getMoviesByLanguage(language);
    }

    @GetMapping("get/director/{director}")
    public ResponseEntity<List<Movie>> getMoviesByDirector(@PathVariable String director){
        return movieService.getMoviesByDirector(director);
    }


}
