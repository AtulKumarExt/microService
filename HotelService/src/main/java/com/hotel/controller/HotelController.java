package com.hotel.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.entities.Hotel;
import com.hotel.service.HotelService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/hotel")
@AllArgsConstructor
public class HotelController {

	private HotelService hotelService;
	
	@PostMapping
	public ResponseEntity<Object> addHotel(@RequestBody Hotel hotel){
		Hotel hotel2=hotelService.addHotel(hotel);
		return new ResponseEntity<Object>(hotel2, HttpStatus.CREATED);
	}
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<Object> findbyId(@PathVariable String hotelId){
		Hotel hotel=hotelService.findById(hotelId);
		return new ResponseEntity<Object>(hotel, HttpStatus.OK);
	}
	@GetMapping("/all")
	public ResponseEntity<Object> getALlHotels(){
		List<Hotel> hotels=hotelService.findAllHotels();
		return new ResponseEntity<Object>(hotels, HttpStatus.OK);
	}
}