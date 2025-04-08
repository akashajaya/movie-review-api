package com.project.postcredit.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReviewData {
    private int reviewId;
    private int rating;
    private String comment;
    private Movie movie;
    private UserNameOnly user;
}
