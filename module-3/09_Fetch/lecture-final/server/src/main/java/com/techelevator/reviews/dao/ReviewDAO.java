package com.techelevator.reviews.dao;

import java.util.List;

import com.techelevator.review.models.Review;
import com.techelevator.reviews.exception.ReviewNotFoundException;

public interface ReviewDAO {

    List<Review> findAll();

    Review create(Review review);

    Review update(Review review, int id) throws ReviewNotFoundException;

    void delete(int id) throws ReviewNotFoundException;

}