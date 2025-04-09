package com.project.postcredit.dao;

import com.project.postcredit.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewDao extends JpaRepository<Review, Integer> {

    @Query(value="SELECT * FROM review WHERE movie_id=:movieId", nativeQuery = true)
    List<Review> findByMovieId(int movieId);

    @Query("SELECT r FROM Review r WHERE r.user.id = :userId AND r.movie.id = :movieId")
    Optional<Review> findByUserIdAndMovieId(@Param("userId") int userId,
                                            @Param("movieId") int movieId);

}
