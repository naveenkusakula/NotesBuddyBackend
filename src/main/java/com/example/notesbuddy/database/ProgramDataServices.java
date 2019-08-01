//Author Name: Sunit Shah
package com.example.notesbuddy.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.notesbuddy.model.Program;


public class ProgramDataServices {

	public static List<Program> getAllPrograms() {
		try {
			DatabaseConfig dbConfig = new DatabaseConfig();
			Connection con = dbConfig.getConnection();
			Statement stmt = con.createStatement();
			String sql = "SELECT  * FROM Program";
			ResultSet result = stmt.executeQuery(sql);
			Program program = null;
			List<Program> programList = new ArrayList<Program>();
			while (result.next()) {
				program = new Program();
				program.setName(result.getString("name"));
				program.setId(result.getLong("id"));
				program.setCourseID(result.getLong("courseID"));
				programList.add(program);
			}
			return programList;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
}
