//<!-- Author: Dhruvi Shah -->

package com.example.notesbuddy.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.notesbuddy.model.User;
import com.example.notesbuddy.sendMail.SendMail;
import com.example.notesbuddy.services.IUserService;

@CrossOrigin("*")
@Controller
public class LoginController {

	@Autowired
	IUserService iUserService;

	@Autowired
	SendMail sendMail;

	@RequestMapping(value = "/userLogin", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> userLogin(@RequestBody User user, HttpServletResponse res, HttpServletRequest req) {
		Map<String, Object> response = new HashMap<String, Object>();
		try {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

			User userObj = iUserService.findUserByUserName(user.getName());
			if (userObj == null) {
				response.put("status", 401);
				response.put("Message", "Bad Credentials");
				return response;
			} else if (passwordEncoder.matches(user.getPassword(), userObj.getPassword())) {
				response.put("status", 200);
				response.put("Message", "Successful Login");
				HttpSession session = req.getSession();
				session.setAttribute("name", userObj.getName());
				session.setAttribute("userId", userObj.getId());
				response.put("username", userObj.getName());
				response.put("userid", userObj.getId());
				response.put("programid", userObj.getProgramID());
				return response;
			} else {
				response.put("status", 502);
				response.put("Message", "Login failed");
				System.out.println("password not matched");
				return response;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			response.put("Message", "login failed");
			return response;
		}
	}

	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> changePassword(@RequestBody User user) {
		Map<String, Object> response = new HashMap<String, Object>();
		try {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(hashedPassword);
			long userDetail = iUserService.changePassword(user.getId(), user);
			if (userDetail == 0) {
				response.put("Message", "User not Updated");
			} else {
				response.put("status", 200);
				response.put("Data", userDetail);
				response.put("Message", "Successful");
			}
			return response;
		} catch (Exception ex) {
			ex.printStackTrace();
			response.put("Message", "User not Updated");
			return response;
		}
	}

	@RequestMapping(value = "/forgetPassword", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> forgetPassword(@RequestBody User user) {
		Map<String, Object> response = new HashMap<String, Object>();
		try {

			User userObj = iUserService.findUserByUserName(user.getName());
			if (userObj == null) {
				response.put("Message", "No data found");
				return response;
			}
			String emailBody = "http://localhost:9080/resetPassword?id=" + userObj.getId();
			sendMail.sendMail(userObj.getName(), "Reset Password Link", emailBody);
			response.put("status", 200);
			response.put("userid", userObj.getId());
			response.put("Message", "Successful");
			return response;
		} catch (Exception ex) {
			ex.printStackTrace();
			response.put("Message", " Unable to update Password");
			return response;
		}
	}

	@GetMapping(value = "/logout")
	public String logout(HttpServletRequest req, HttpServletResponse res) {
		Map<String, Object> response = new HashMap<String, Object>();
		try {
			HttpSession session = req.getSession();
			String username = (String) session.getAttribute("name");
			if (username != null) {
				session.invalidate();
				return "Logged out";
			} else {
				return "Invalid session";
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			response.put("Error", "Unable to logout");
			return null;
		}
	}

}
