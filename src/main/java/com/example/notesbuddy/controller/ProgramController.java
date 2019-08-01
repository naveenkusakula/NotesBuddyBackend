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
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.notesbuddy.model.Program;
import com.example.notesbuddy.services.IProgramService;

@CrossOrigin("*")
@Controller
public class ProgramController {

	@Autowired
	IProgramService  iProgramService;
	
	
	@RequestMapping(value = "/getPrograms", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getPrograms() {
		Map<String, Object> response = new HashMap<String, Object>();
		try {
			List<Program> programList = iProgramService.getAllPrograms();
			if (programList == null) {
				response.put("Message", "Courses not found");
			} else {
				response.put("status", 200);
				response.put("Data", programList);
				response.put("Message", "Successfull");
			}
			return response;
		} catch (Exception ex) {
			ex.printStackTrace();
			response.put("Message", "Courses not found");
			return response;
		}
	}
	
}

