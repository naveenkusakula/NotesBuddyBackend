package com.example.notesbuddy.database;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.notesbuddy.model.SavedArticles;

public interface SavedArticlesServices extends CrudRepository<SavedArticles, Long> {
	
	
	public List<SavedArticles> findByUserId(long userId);
	
	public SavedArticles save(SavedArticles userId);
	
	public void deleteById(long id);

}
