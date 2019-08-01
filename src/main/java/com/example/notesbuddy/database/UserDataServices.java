//<!-- Author: Dhruvi Shah -->

package com.example.notesbuddy.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.stereotype.Component;

import com.example.notesbuddy.model.User;

@Component
public class UserDataServices {


	public static User findUserById(long userId) {
		try {
			DatabaseConfig dbConfig = new DatabaseConfig();
			Connection con = dbConfig.getConnection();
			Statement stmt = con.createStatement();
			String sql = "SELECT DISTINCT * FROM user where id=" + userId + "";
			ResultSet result = stmt.executeQuery(sql);
			User user = new User();
			while (result.next()) {
				user.setId(result.getLong("id"));
				user.setName(result.getString("name"));
				user.setEmailID(result.getString("emailID"));
				user.setPassword(result.getString("password"));
				user.setProgramID(result.getLong("programid"));
				user.setCourseID(result.getString("courseid"));
				user.setAdmin(result.getBoolean("is_admin"));
				return user;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static User findUserByName(String name) {
		try {
			DatabaseConfig dbConfig = new DatabaseConfig();
			Connection con = dbConfig.getConnection();
			Statement stmt = con.createStatement();
			String sql = "SELECT DISTINCT * FROM user where name = \'" + name + "'";
			ResultSet result = stmt.executeQuery(sql);
			User user = new User();
			while (result.next()) {
				user.setId(result.getLong("id"));
				user.setName(result.getString("name"));
				user.setEmailID(result.getString("emailID"));
				user.setPassword(result.getString("password"));
				user.setProgramID(result.getLong("programid"));
				user.setCourseID(result.getString("courseid"));
				user.setAdmin(result.getBoolean("is_admin"));
				return user;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static long updateUserDetail(long userId, User loggeduser) {
		try {
			DatabaseConfig dbConfig = new DatabaseConfig();
			Connection con = dbConfig.getConnection();
			Statement stmt = con.createStatement();
			String sql = "UPDATE user SET name =\"" + loggeduser.getName() + "\",emailid =\"" + loggeduser.getEmailID() + "\",password = \"" + loggeduser.getPassword() + "\",courseID = \"" + loggeduser.getCourseID() + "\",programID="+loggeduser.getProgramID()+",is_admin ="+ loggeduser.isAdmin()+" where id=" + userId + "";
			stmt.executeUpdate(sql);
			return userId; 
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	public static long deleteUserById(long userId) {

		try {
			DatabaseConfig dbConfig = new DatabaseConfig();
			Connection	con = dbConfig.getConnection();
			Statement stmt = con.createStatement();
			String sql = "DELETE FROM user where id=" + userId + "";
			userId = stmt.executeUpdate(sql);
			return userId;
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	public static long addUser(User registeringUser) {
		long userId = 0;	
		try {
			DatabaseConfig dbConfig = new DatabaseConfig();
			Connection con = dbConfig.getConnection();
			Statement stmt = con.createStatement();

			String sql = "INSERT INTO user(name,emailid,password,programid,courseid,is_admin) VALUES "
					+ "(\"" + registeringUser.getName()+ "\",\"" + registeringUser.getEmailID()+ "\",\"" + registeringUser.getPassword() + "\","+ registeringUser.getProgramID() + ",\""
					+ registeringUser.getCourseID() + "\","+ registeringUser.isAdmin() +")";;
			userId = stmt.executeUpdate(sql);
			return userId;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return userId;
	}


}
