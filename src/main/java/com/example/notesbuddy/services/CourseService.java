//Author Name: Sunit Shah
package com.example.notesbuddy.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.notesbuddy.database.CourseDataServices;
import com.example.notesbuddy.model.Course;

@Service
public class CourseService implements ICourseService{

	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		return CourseDataServices.getAllCourses();
	}

//	@Override
//	public List<Course> getAllCoursesForUser(Long UserId) {
//		// TODO Auto-generated method stub
//		return CourseDataServices.getAllCoursesForUser(UserId);
//	}

	@Override
	public List<Course> getAllCoursesForProgram(long ProgramId) {
		// TODO Auto-generated method stub
		return CourseDataServices.getAllCoursesForProgram(ProgramId);
	}

	@Override
	public Course getCourseDetail(long courseID) {
		// TODO Auto-generated method stub
		return CourseDataServices.getCourseDetail(courseID);
	}

}
