package com.example.notesbuddy.services;

import java.util.List;

import com.example.notesbuddy.model.SavedArticles;

public interface ISavedArticlesService {
	
	
	public SavedArticles save(SavedArticles savedArticles);
	public List<SavedArticles> findAll();
	public List<SavedArticles> findByUserId(long userId);
	public SavedArticles findById(long id);
	public boolean deleteById(long id);
	

}
