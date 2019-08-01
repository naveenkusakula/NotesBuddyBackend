package com.example.notesbuddy.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.notesbuddy.model.Rating;

@Repository
public interface IRatingRespository extends CrudRepository<Rating, Long> {

	public ArrayList<Rating> findByNoteID(long noteId);
}
