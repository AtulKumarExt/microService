package com.hotel.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.entities.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, String>{

}
