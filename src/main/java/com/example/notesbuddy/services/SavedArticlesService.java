package com.example.notesbuddy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.notesbuddy.database.SavedArticlesServices;
import com.example.notesbuddy.model.SavedArticles;

@Service
public class SavedArticlesService implements ISavedArticlesService{
	
	
	@Autowired
	SavedArticlesServices saveArticlesServices;

	@Override
	public SavedArticles save(SavedArticles savedArticles) {
		// TODO Auto-generated method stub
		//return saveArticlesServices.save(savedArticles);
		return saveArticlesServices.save(savedArticles);
	}

	@Override
	public List<SavedArticles> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SavedArticles> findByUserId(long userId) {
		// TODO Auto-generated method stub
		return saveArticlesServices.findByUserId(userId);
	}

	@Override
	public SavedArticles findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(long id) {
		// TODO Auto-generated method stub
		saveArticlesServices.deleteById(id);
		return true;
	}

}
