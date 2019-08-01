package com.example.notesbuddy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.notesbuddy.model.SavedArticles;
import com.example.notesbuddy.services.ISavedArticlesService;

@CrossOrigin("*")
@Controller
public class SavedArticlesController {
	
	
	
	@Autowired
	ISavedArticlesService  iSavedArticlesService;

	@RequestMapping(value = "/saveBookmarkArticles", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getNotesForCourse(@RequestBody SavedArticles savedArticles) {
		Map<String, Object> response = new HashMap<String, Object>();
		try {
			SavedArticles saveArticlesId = iSavedArticlesService.save(savedArticles);
			response.put("status", 200);
			response.put("data", saveArticlesId);
			return response;
		} catch (Exception ex) {
			ex.printStackTrace();
			response.put("error", "not saved successfully");
			return response;
		}
	}

	
	@RequestMapping(value = "/getAllSavedArticles/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getAllSavedArticles(@PathVariable long userId) {
		Map<String, Object> response = new HashMap<String, Object>( );
		try {
			List<SavedArticles> saveArticlesList = iSavedArticlesService.findByUserId(userId);
			response.put("status", 200);
			response.put("data", saveArticlesList);
			return response;
		} catch (Exception ex) {
			ex.printStackTrace();
			response.put("error", "Artciles not found");
			return response;
		}
	}
	

	@RequestMapping(value = "/deleteSavedArticle/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> deleteSavedArticle(@PathVariable long id) {
		Map<String, Object> response = new HashMap<String, Object>( );
		try {
			boolean check = iSavedArticlesService.deleteById(id);
			response.put("status", 200);
			response.put("data", check);
			return response;
		} catch (Exception ex) {
			ex.printStackTrace();
			response.put("error", "Artciles not deleted succesfully");
			return response;
		}
	}
}

