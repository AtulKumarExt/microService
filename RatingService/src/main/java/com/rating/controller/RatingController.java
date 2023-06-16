package com.rating.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rating.entities.Rating;
import com.rating.service.RatingService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/rating")
@AllArgsConstructor
public class RatingController {

	private RatingService ratingService;
	
	@PostMapping
	public ResponseEntity<Object> addRating(@RequestBody Rating rating){
		Rating rating2=ratingService.addRating(rating);
		return new ResponseEntity<Object>(rating2, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<Object> getAllRating(){
		List<Rating> ratings=ratingService.getAllRatings();
		return new ResponseEntity<Object>(ratings, HttpStatus.OK);
	}
	@GetMapping("/user/{userId}")
	public ResponseEntity<Object> getAlbyuserId(@PathVariable String userId){
		List<Rating> ratings=ratingService.getRatingByUserId(userId);
		return new ResponseEntity<Object>(ratings, HttpStatus.OK);
	}
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<Object> getAllByHotelId(@PathVariable String hotelId){
		List<Rating> ratings=ratingService.getRatingByHOtelId(hotelId);
		return new ResponseEntity<Object>(ratings, HttpStatus.OK);
	}
}
