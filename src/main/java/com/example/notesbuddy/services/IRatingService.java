package com.example.notesbuddy.services;

import org.springframework.stereotype.Service;

import com.example.notesbuddy.model.Rating;

@Service
public interface IRatingService {
	
	public Rating save(Rating rate);

	public void calculateAverageRating(long notesID);

}
