//Author Name: Sunit Shah
package com.example.notesbuddy.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.example.notesbuddy.model.Notes;

public class NotesDataServices {

	public static List<Notes> getAllNotesForCourse(Long courseId) {
		try {
			DatabaseConfig dbConfig = new DatabaseConfig();
			Connection con = dbConfig.getConnection();
			Statement stmt = con.createStatement();
			String sql = "SELECT  * FROM notes where courseid ="+courseId;
			ResultSet result = stmt.executeQuery(sql);
			Notes notes = null;
			List<Notes> notesList = new ArrayList<Notes>();
			while (result.next()) {
				notes = new Notes();
				notes.setCourseID(result.getLong("courseID"));
				notes.setLocation(result.getString("location"));
				notes.setName(result.getString("name"));
				notes.setUploadDate(result.getTimestamp("upload_date"));
				notes.setUserID(result.getInt("userID"));
				notes.setAverageRating(result.getInt("average_rating"));
				notes.setId(result.getLong("id"));
				notesList.add(notes);
			}
			return notesList;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static List<Notes> getAllNotesByParam(String searchParam) {
		try {
			DatabaseConfig dbConfig = new DatabaseConfig();
			Connection con = dbConfig.getConnection();
			Statement stmt = con.createStatement();
			String sql = "SELECT  * FROM notes where name like '%"+searchParam+"%'";
			ResultSet result = stmt.executeQuery(sql);
			Notes notes = null;
			List<Notes> notesList = new ArrayList<Notes>();
			while (result.next()) {
				notes = new Notes();
				notes.setCourseID(result.getLong("courseID"));
				notes.setLocation(result.getString("location"));
				notes.setName(result.getString("name"));
				notes.setUploadDate(result.getTimestamp("upload_date"));
				notes.setUserID(result.getInt("userID"));
				notes.setAverageRating(result.getInt("average_rating"));
				notes.setId(result.getLong("id"));
				notesList.add(notes);
			}
			return notesList;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
}

