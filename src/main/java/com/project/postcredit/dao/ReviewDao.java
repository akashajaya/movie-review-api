package com.project.postcredit.dao;

import com.project.postcredit.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewDao extends JpaRepository<Review, Integer> {

    @Query(value="SELECT * FROM review WHERE movie_id=:movieId", nativeQuery = true)
    List<Review> findByMovieId(int movieId);
}
