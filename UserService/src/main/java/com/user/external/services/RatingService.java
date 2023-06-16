package com.user.external.services;

import javax.ws.rs.PUT;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.user.entities.Rating;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

	@PostMapping("/rating")
	Rating addRating(Rating rating);
	
	@PutMapping("/rating/{ratingId}")
	Rating updateRating(@PathVariable String ratingId, Rating rating);
	
	@DeleteMapping("/rating/{ratingId}")
	void deleteRating(@PathVariable String ratingId);
}
