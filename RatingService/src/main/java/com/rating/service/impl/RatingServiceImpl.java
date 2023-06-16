package com.rating.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.rating.entities.Rating;
import com.rating.repo.RatingRepo;
import com.rating.service.RatingService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RatingServiceImpl implements RatingService{

	private RatingRepo ratingRepo;

	@Override
	public Rating addRating(Rating rating) {
		// TODO Auto-generated method stub
		String ratingId=UUID.randomUUID().toString();
		rating.setRatingId(ratingId);
		return ratingRepo.save(rating);
	}

	@Override
	public List<Rating> getAllRatings() {
		// TODO Auto-generated method stub
		return ratingRepo.findAll();
	}

	@Override
	public Rating findById(String ratingId) {
		// TODO Auto-generated method stub
		return ratingRepo.findById(ratingId).get();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		// TODO Auto-generated method stub
		return ratingRepo.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHOtelId(String hotelId) {
		// TODO Auto-generated method stub
		return ratingRepo.findByHotelId(hotelId);
	}
	
	
}
