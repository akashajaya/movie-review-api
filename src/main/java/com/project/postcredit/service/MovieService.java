package com.project.postcredit.service;

import com.project.postcredit.dao.MovieDao;
import com.project.postcredit.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieDao movieDao;

    public ResponseEntity<String> addMovie(Movie movie) {
        try{
            movieDao.save(movie);
            return ResponseEntity.ok("Movie Added Successfully");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(500).body("something went wrong");
        }
    }

    public ResponseEntity<List<Movie>> getMoviesByGenre(String genre) {
        try {
            List<Movie> movies = movieDao.getMoviesByGenre(genre);
            return ResponseEntity.ok(movies);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }

    public ResponseEntity<List<Movie>> getMoviesByLanguage(String language) {
        try {
            List<Movie> movies = movieDao.getMoviesByLanguage(language);
            return ResponseEntity.ok(movies);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }

    public ResponseEntity<List<Movie>> getMoviesByDirector(String director) {
        try{
            List<Movie> movies = movieDao.getMoviesByDirector(director);
            return ResponseEntity.ok(movies);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }
}
