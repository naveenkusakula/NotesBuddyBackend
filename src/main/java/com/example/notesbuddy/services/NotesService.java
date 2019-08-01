package com.example.notesbuddy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.notesbuddy.database.NotesDataServices;
import com.example.notesbuddy.model.Notes;
import com.example.notesbuddy.repositories.INotesRepository;

@Service
public class NotesService implements INotesService {

	@Autowired
	INotesRepository notesRepository;

	@Override
	public Notes save(Notes notes) {
		return notesRepository.save(notes);
	}

	@Override
	public Notes getNotes(long id) {
		return notesRepository.findById(id).orElse(null);
	}

	@Override
	public List<Notes> getAllNotesForCourse(long courseID) {
		// TODO Auto-generated method stub
		return NotesDataServices.getAllNotesForCourse(courseID);
		//return CourseDataServices.getAllNotesForCourse(courseID);
	}

	@Override
	public List<Notes> getAllNotesByParam(String searchParam) {
		return NotesDataServices.getAllNotesByParam(searchParam);
	}

}
