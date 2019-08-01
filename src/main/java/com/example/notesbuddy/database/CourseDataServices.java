//Author Name: Sunit Shah
package com.example.notesbuddy.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.notesbuddy.model.Course;

public class CourseDataServices {


	public static List<Course> getAllCourses() {
		try {
			DatabaseConfig dbConfig = new DatabaseConfig();
			Connection con = dbConfig.getConnection();
			Statement stmt = con.createStatement();
			String sql = "SELECT  * FROM Course";
			ResultSet result = stmt.executeQuery(sql);
			Course course = null;
			List<Course> courseList = new ArrayList<Course>();
			while (result.next()) {
				course = new Course();
				course.setId(result.getLong("id"));
				course.setName(result.getString("name"));
				course.setProgramID(result.getLong("ProgramID"));
				course.setDescription(result.getString("description"));
				courseList.add(course);
			}
			return courseList;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
//	public static List<Course> getAllCoursesForUser(long userID)
//	{
//		try {
//			DatabaseConfig dbConfig = new DatabaseConfig();
//			Connection con = dbConfig.getConnection();
//			Statement stmt = con.createStatement();
//			String sql = "SELECT  * FROM Course where id in (Select courseid from user where id= "+userID+")";
//			ResultSet result = stmt.executeQuery(sql);
//			Course course = null;
//			List<Course> courseList = new ArrayList<Course>();
//			while (result.next()) {
//				course = new Course();
//				course.setId(result.getLong("id"));
//				course.setName(result.getString("name"));
//				course.setProgramID(result.getLong("ProgramID"));
//				courseList.add(course);
//			}
//			return courseList;
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//		return null;
//	}
	
	public static Course getCourseDetail(long courseID)
	{
		try {
			DatabaseConfig dbConfig = new DatabaseConfig();
			Connection con = dbConfig.getConnection();
			Statement stmt = con.createStatement();
			String sql = "SELECT  * FROM Course where id ="+courseID;
			ResultSet result = stmt.executeQuery(sql);
			Course course =  new Course();
				course.setId(result.getLong("id"));
				course.setName(result.getString("name"));
				course.setProgramID(result.getLong("ProgramID"));
				course.setDescription(result.getString("description"));
			return course;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public static List<Course>	getAllCoursesForProgram(long programID)
	{
		try {
			DatabaseConfig dbConfig = new DatabaseConfig();
			Connection con = dbConfig.getConnection();
			Statement stmt = con.createStatement();
			String sql = "SELECT  * FROM Course where programid ="+programID;
			ResultSet result = stmt.executeQuery(sql);
			Course course = null;
			List<Course> courseList = new ArrayList<Course>();
			while (result.next()) {
				course = new Course();
				course.setId(result.getLong("id"));
				course.setName(result.getString("name"));
				course.setProgramID(result.getLong("ProgramID"));
				course.setDescription(result.getString("description"));
				courseList.add(course);
			}
			return courseList;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
}
