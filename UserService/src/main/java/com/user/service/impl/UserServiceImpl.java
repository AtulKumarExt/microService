package com.user.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.entities.Hotel;
import com.user.entities.Rating;
import com.user.entities.User;
import com.user.exception.ResourceNotFoundException;
import com.user.external.services.HotelService;
import com.user.repo.UserRepo;
import com.user.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{

	private UserRepo userRepo;
	private RestTemplate restTemplate;
	private HotelService hotelService;

	@Override
	public User addUser(User user) {
		String userId=UUID.randomUUID().toString();
		user.setUserId(userId);
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public User findById(String id) {
		// TODO Auto-generated method stub.
		 User user = getById(id);
//		 localhost:8083/rating/user/89e65820-6b28-4067-9473-8f7162bcc144
		 Rating[] ratingOfUser = restTemplate.getForObject("http://RATING-SERVICE/rating/user/"+id, Rating[].class);
		 List<Rating> ratings = Arrays.stream(ratingOfUser).toList();
		 List<Rating > ratingList=ratings.stream().map(rating ->{
			 
//			 ResponseEntity<Hotel> entity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/"+rating.getHotelId(),Hotel.class);
//			 Hotel hotel = entity.getBody();
			 Hotel hotel = hotelService.getHotel(rating.getHotelId());
			 rating.setHotel(hotel);
			 return rating;
		 }).collect(Collectors.toList());
		 user.setRatings(ratingList);
		 return user;
	}

	private User getById(String id) {
		return userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("user is not found with this id "+id));
	}

	@Override
	public void delete(String id) {
		User user=getById(id);
		userRepo.delete(user);
	}

	@Override
	public User update(User user) {
		getById(user.getUserId());
		
		return null;
	}
}
