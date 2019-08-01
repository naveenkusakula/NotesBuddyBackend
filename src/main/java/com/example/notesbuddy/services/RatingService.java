package com.example.notesbuddy.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.notesbuddy.model.Rating;
import com.example.notesbuddy.repositories.INotesRepository;
import com.example.notesbuddy.repositories.IRatingRespository;

@Service
public class RatingService implements IRatingService {

	@Autowired
	IRatingRespository ratingRepository;

	@Autowired
	INotesRepository notesRepository;

	@Override
	public Rating save(Rating rate) {
		return ratingRepository.save(rate);
	}

	@Override
	public void calculateAverageRating(long notesId) {
		long AverageRating = 0;
		ArrayList<Rating> ratings = new ArrayList<Rating>();
		ratings = ratingRepository.findByNoteID(notesId);
		
		for (int i = 0; i < ratings.size(); i++) {
			AverageRating += ratings.get(i).getRating();
		}

		long avgRating = AverageRating / ratings.size();
		System.out.println(avgRating);
		notesRepository.updateAverageRating(avgRating,notesId);
	}

}
