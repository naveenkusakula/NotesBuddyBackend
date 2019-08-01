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

import com.example.notesbuddy.model.Course;
import com.example.notesbuddy.services.ICourseService;

@CrossOrigin("*")
@Controller
//Author Name: Sunit Shah
public class CourseController {

	@Autowired
	ICourseService  iCourseService;
	
	@RequestMapping(value = "/getCourseDetail", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getCourseDetail(@RequestParam("courseId") long courseId) {
		Map<String, Object> response = new HashMap<String, Object>();
		try {
			Course course = iCourseService.getCourseDetail(courseId);
			if (course == null) {
				response.put("Message", "Courses not found");
			} else {
				response.put("status", 200);
				response.put("data", course);
				response.put("Message", "Successfull");
			}
			return response;
		} catch (Exception ex) {
			ex.printStackTrace();
			response.put("Message", "Courses not found");
			return response;
		}
	}
	
	
	@RequestMapping(value = "/getCoursesForProgram", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getCoursesForProgram(@RequestParam("programId") long programId) {
		Map<String, Object> response = new HashMap<String, Object>();
		try {
			List<Course> courseList = iCourseService.getAllCoursesForProgram(programId);
			if (courseList == null) {
				response.put("Message", "Courses not found");
			} else {
				response.put("status", 200);
				response.put("Data", courseList);
				response.put("Message", "Successfull");
			}
			return response;
		} catch (Exception ex) {
			ex.printStackTrace();
			response.put("Message", "Courses not found");
			return response;
		}
	}
	
	
	@RequestMapping(value = "/getCourses", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getCourses() {
		Map<String, Object> response = new HashMap<String, Object>();
		try {
			List<Course> courseList = iCourseService.getAllCourses();
			if (courseList == null) {
				response.put("Message", "Courses not found");
			} else {
				response.put("status", 200);
				response.put("data", courseList);
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
