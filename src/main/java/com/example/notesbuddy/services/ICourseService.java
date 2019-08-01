//Author Name: Sunit Shah
package com.example.notesbuddy.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.notesbuddy.model.Course;


public interface ICourseService 
{
	public List<Course> getAllCoursesForProgram(long programID);
	public List<Course> getAllCourses();
	public Course getCourseDetail(long courseID);
	
//	public List<Course> getAllCoursesForUser(Long UserId);
}
