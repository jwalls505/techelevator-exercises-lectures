package com.techelevator.reviews.controllers;

import com.techelevator.review.models.Review;
import com.techelevator.reviews.dao.ReviewDAO;
import com.techelevator.reviews.exception.ReviewNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = { "http://127.0.0.1:5500", "http://localhost:5500" })
@RestController
public class ReviewController {

	@Autowired
    private ReviewDAO reviewDAO;


    /**
     * Return All Reviews
     *
     * @return a list of all reviews in the system
     */
	
    @RequestMapping(path = "/reviews", method = RequestMethod.GET)
    public List<Review> list() {
        return reviewDAO.findAll();
    }

    /**
     * Create a new review
     *
     * @param review
     */
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/reviews", method = RequestMethod.POST)
    public Review addReview(@Valid @RequestBody Review review) {
        return reviewDAO.create(review);
    }

    /**
     * Updates a review
     *
     * @param review
     * @param id
     * @return the updated Review
     * @throws ReviewNotFoundException
     */
    @RequestMapping(path = "/reviews/{id}", method = RequestMethod.PUT)
    public Review update(@Valid @RequestBody Review review, @PathVariable int id) throws ReviewNotFoundException {
        return reviewDAO.update(review, id);
    }

    /**
     * Delete a review by id
     *
     * @param id
     * @throws ReviewNotFoundException
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/reviews/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) throws ReviewNotFoundException {
    	reviewDAO.delete(id);
    }

}
