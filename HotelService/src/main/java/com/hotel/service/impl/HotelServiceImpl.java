package com.hotel.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.hotel.entities.Hotel;
import com.hotel.exception.ResourceNotFoundException;
import com.hotel.repo.HotelRepo;
import com.hotel.service.HotelService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class HotelServiceImpl implements HotelService{

	private HotelRepo hotelRepo;

	@Override
	public Hotel addHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		String hotelId=UUID.randomUUID().toString();
		hotel.setId(hotelId);
		return hotelRepo.save(hotel);
	}

	@Override
	public Hotel findById(String id) {
		return getById(id);
	}

	private Hotel getById(String id) {
		return hotelRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("hotel is found with this id "+id));
	}

	@Override
	public List<Hotel> findAllHotels() {
		// TODO Auto-generated method stub
		return hotelRepo.findAll();
	}
}
