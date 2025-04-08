package com.project.postcredit.dao;

import com.project.postcredit.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieDao extends JpaRepository<Movie, Integer> {


    @Query(value="SELECT * FROM movie WHERE genre=:genre", nativeQuery = true)
    public List<Movie> getMoviesByGenre(String genre);

    @Query(value="SELECT * FROM movie WHERE language=:language", nativeQuery = true)
    public List<Movie> getMoviesByLanguage(String language);

    @Query(value="SELECT * FROM movie WHERE director=:director", nativeQuery = true)
    public List<Movie> getMoviesByDirector(String director);
}
