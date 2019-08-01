package com.example.notesbuddy.services;

import java.util.List;

import com.example.notesbuddy.model.Notes;


public interface INotesService {
	public Notes save(Notes notes);
	
	public Notes getNotes(long id);
	
	public List<Notes> getAllNotesForCourse(long courseID);

	public List<Notes> getAllNotesByParam(String searchParam);
}
