package com.hotel.service;

import java.util.List;

import com.hotel.entities.Hotel;

public interface HotelService {

	Hotel addHotel(Hotel hotel);
	Hotel findById(String id);
	List<Hotel> findAllHotels();
}
