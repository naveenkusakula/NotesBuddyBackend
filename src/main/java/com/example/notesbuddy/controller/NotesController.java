//Author Name: Sunit Shah
package com.example.notesbuddy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.notesbuddy.model.Notes;
import com.example.notesbuddy.services.INotesService;

@CrossOrigin("*")
@Controller
public class NotesController
{
	@Autowired
	INotesService  iNotesService;

	@RequestMapping(value = "/getNotes", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getNotesForCourse(@RequestParam("courseId") long courseId) {
		Map<String, Object> response = new HashMap<String, Object>();
		try {
			List<Notes> notesList = iNotesService.getAllNotesForCourse(courseId);
			if (notesList.size() == 0) {
				response.put("Message", "Notes not found");
			} else {
				response.put("status", 200);
				response.put("Data", notesList);
				response.put("Message", "Successfull");
			}
			return response;
		} catch (Exception ex) {
			ex.printStackTrace();
			response.put("Message", "Notes not found");
			return response;
		}
	}

	@RequestMapping(value = "/getNotesByParam", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getNotesByParam(@RequestParam("searchParam") String searchParam) {
		Map<String, Object> response = new HashMap<String, Object>();
		try {
			List<Notes> notesList = iNotesService.getAllNotesByParam(searchParam);
			if (notesList.size() == 0) {
				response.put("Message", "Notes not found");
			} else {
				response.put("status", 200);
				response.put("Data", notesList);
				response.put("Message", "Successfull");
			}
			return response;
		} catch (Exception ex) {
			ex.printStackTrace();
			response.put("Message", "Notes not found");
			return response;
		}
	}
}
