package com.example.notesbuddy.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.notesbuddy.model.Rating;
import com.example.notesbuddy.services.IRatingService;

@RestController
public class RatingController {
	
	@Autowired
	IRatingService ratingService;

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/rate", method = RequestMethod.POST)
	public ResponseEntity<Rating> rateNotes(@RequestBody Rating rate) {

		Rating ratedNotes = ratingService.save(rate);
		System.out.print(rate.getNoteID());
		System.out.print(rate.getRating());
		ratingService.calculateAverageRating(rate.getNoteID());
		
		if (null == ratedNotes) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.ok(ratedNotes);
	}


}
