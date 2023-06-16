package com.rating.service;

import java.util.List;

import com.rating.entities.Rating;

public interface RatingService {

	Rating addRating(Rating rating);
	List<Rating> getAllRatings();
	Rating findById(String ratingId);
	
	List<Rating> getRatingByUserId(String userId);
	List<Rating> getRatingByHOtelId(String hotelId);
}