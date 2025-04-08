package com.project.postcredit.model;

import lombok.Data;

@Data
public class ReviewReq {
    private int rating;
    private String comment;
}
