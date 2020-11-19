package com.techelevator.reviews.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.techelevator.review.models.Review;
import com.techelevator.reviews.exception.ReviewNotFoundException;

@Component
public class MemoryReviewDAO implements ReviewDAO {

    private static List<Review> reviews = new ArrayList<>();

    public MemoryReviewDAO() {
    	reviews.add(new Review(getMaxIdPlusOne(),
                "Malcolm Gladwell",
                "What a book!",
                "It certainly is a book. I mean, I can see that. Pages kept together with glue (I hope that's glue) and there's writing on it, in some language.",
                3));
    }
    
    public List<Review> findAll() {
        return reviews;
    }

    @Override
    public Review create(Review review) {
    	review.setId(getMaxIdPlusOne());
        reviews.add(review);
        return review;
    }

    @Override
    public Review update(Review review, int id) throws ReviewNotFoundException {
        Review result = review;
        boolean finished = false;
        List<Review> reservations = findAll();

        for (int i = 0; i < reservations.size(); i++) {
            if (reservations.get(i).getId() == id) {
                if( result.getId() == 0 ) {
                    result.setId(id);
                }
                reservations.set(i, result);
                finished = true;
                break;
            }
        }
        if (!finished) {
            throw new ReviewNotFoundException();
        }

        return result;
    }

    @Override
    public void delete(int id) throws ReviewNotFoundException {
        boolean found = false;
        // avoid concurrent modification exception using iterator
        for(Iterator<Review> iterator = reviews.iterator(); iterator.hasNext(); ) {
            Review reservation = iterator.next();
            if(reservation.getId() == id) {
                iterator.remove();
                found = true;
            }
        }
        if( !found ) {
            throw new ReviewNotFoundException();
        }
    }

    /**
     * finds the max id in the list of reservations and returns it
     *
     * @return int the max id
     */
    private int getMaxID() {
        int maxID = 0;
        for (Review r : reviews) {
            if (r.getId() > maxID) {
                maxID = r.getId();
            }
        }
        return maxID;
    }

    /**
     * Adds 1 to the max id and returns it
     *
     * @return
     */
    private int getMaxIdPlusOne() {
        return getMaxID() + 1;
    }

}
