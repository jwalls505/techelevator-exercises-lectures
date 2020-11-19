package com.techelevator.reviews.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( code = HttpStatus.NOT_FOUND, reason = "Review not found.")
public class ReviewNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public ReviewNotFoundException() {
        super("Review not found.");
    }
}
