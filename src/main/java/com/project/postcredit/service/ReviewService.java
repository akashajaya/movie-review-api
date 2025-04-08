package com.project.postcredit.service;

import com.project.postcredit.dao.MovieDao;
import com.project.postcredit.dao.ReviewDao;
import com.project.postcredit.dao.UserDataDao;
import com.project.postcredit.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    ReviewDao reviewDao;

    @Autowired
    MovieDao movieDao;

    @Autowired
    UserDataDao userDataDao;


    public ResponseEntity<String> postReview(int userId, int movieId, int rating, String comment) {
        try {
            UserData user = userDataDao.findById(userId).orElse(null);
            Movie movie = movieDao.findById(movieId).orElse(null);

            if (user == null || movie == null) {
                return ResponseEntity.badRequest().body("Invalid user or movie ID");
            }

            Review review = new Review();
            review.setUser(user);
            review.setMovie(movie);
            review.setRating(rating);
            review.setComment(comment);

            reviewDao.save(review);
            return ResponseEntity.ok("Review posted successfully");

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("An error occurred while posting the review");
        }
    }

    public ResponseEntity<List<ReviewData>> viewReview(int movieId) {
        try {
            List<Review> reviews = reviewDao.findByMovieId(movieId);

            List<ReviewData> result = reviews.stream().map(review -> new ReviewData(
                    review.getReviewId(),
                    review.getRating(),
                    review.getComment(),
                    review.getMovie(),
                    new UserNameOnly(review.getUser().getUserName())
            )).toList();

            return ResponseEntity.ok(result);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

}
