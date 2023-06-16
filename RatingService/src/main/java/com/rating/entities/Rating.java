package com.rating.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Rating {

	@Id
	private String ratingId;
	private String userId;
	private String hotelId;
	private String feedback;
	private int rating;
	
}
