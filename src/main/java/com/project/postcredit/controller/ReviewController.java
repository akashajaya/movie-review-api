package com.project.postcredit.controller;

import com.project.postcredit.model.Review;
import com.project.postcredit.model.ReviewData;
import com.project.postcredit.model.ReviewReq;
import com.project.postcredit.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @PostMapping("post/{userId}/{movieId}")
    public ResponseEntity<String> postReview(@PathVariable int userId, @PathVariable int movieId,
                                             @RequestBody ReviewReq reviewReq){
        return reviewService.postReview(userId,movieId,reviewReq.getRating(), reviewReq.getComment());
    }

    @GetMapping("view/{movieId}")
    public  ResponseEntity<List<ReviewData>> viewReview (@PathVariable int movieId){
        return reviewService.viewReview(movieId);
    }

    @GetMapping("view/{userId}/{movieId}")
    public ResponseEntity<ReviewData> getReview(@PathVariable int userId,
                                                @PathVariable int movieId) {
        return reviewService.getReview(userId, movieId);
    }

    @PutMapping("update/{userId}/{movieId}")
    public ResponseEntity<ReviewData> updateReview(@PathVariable int userId, @PathVariable int movieId,
                                                   @RequestBody ReviewReq reviewReq) {
        return reviewService.updateReview(userId, movieId, reviewReq);
    }
    @DeleteMapping("delete/{userId}/{movieId}")
    public ResponseEntity<String> deleteReview(@PathVariable int userId, @PathVariable int movieId) {
        return reviewService.deleteReview(userId, movieId);
    }




}
