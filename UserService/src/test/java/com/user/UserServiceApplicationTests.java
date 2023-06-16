package com.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.user.entities.Rating;
import com.user.external.services.RatingService;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private RatingService ratingService;
	
	
	void createRating() {
		Rating rating=Rating.builder().feeback("this is the feedback form").hotelId("hotelID").rating(1).build();
		Rating ratings = ratingService.addRating(rating);
		System.out.println("saved rating sare "+ratings);
	}
	
}
