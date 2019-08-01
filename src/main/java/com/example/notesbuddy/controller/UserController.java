//<!-- Author: Dhruvi Shah -->

package com.example.notesbuddy.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.notesbuddy.model.User;
import com.example.notesbuddy.services.IUserService;
import com.example.notesbuddy.services.UserService;

@CrossOrigin("*")
@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> addUser(@RequestBody User user) {
		Map<String,Object> response = new HashMap<String, Object>();
		try {
			IUserService iUserService = new UserService();
			long userDetail = iUserService.Register(user);
			if (userDetail == 0) {
				response.put("status", 404);
				response.put("Message", "User not Added");
			} else {
				response.put("status", 200);
				response.put("Message", " Registeration Successfully");
			}
			return response;
		} catch (Exception ex) {
			ex.printStackTrace();
			response.put("Message", "User not Added");
			return response;
		}
	}
	
	@RequestMapping(value = "/updateUserDetails", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateUserDetails(@RequestParam(value = "userId", required = true) long userId,
			@RequestBody User user) {
		Map<String, Object> response = new HashMap<String, Object>();
		try {
			IUserService iUserService =  new UserService();
			long userDetail = iUserService.updateUserDetail(userId,user);
			if (userDetail == 0) {
				response.put("Message", "User not Updated");
			} else {
				response.put("status", 200);
				response.put("data", userDetail);
				response.put("Message", "Successful");
			}
			return response;
		} catch (Exception ex) {
			ex.printStackTrace();
			response.put("Message", "User not Updated");
			return response;
		}
	}

	@RequestMapping(value = "/deleteUserbyId", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> deleteUserbyId(@RequestParam("userId") long userId) {
		Map<String, Object> response = new HashMap<String, Object>();
		try {
			IUserService iUserService = new UserService();
			long deletedUserAction =  iUserService.deleteUser(userId);
			if(deletedUserAction == 0)
			{
				response.put("status", 404);
				response.put("Message", "Account not deleted");
			}
			else
			{
				response.put("status", 200);
				response.put("Message","delete Successfully");
			}
			return response;
		} catch (Exception ex) {
			ex.printStackTrace();
			response.put("Message", "User not deleted");
			return response;
		}
	}

	@RequestMapping(value = "/findUserByUserName", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> findUserByUserName(@RequestParam("userName") String userName) {
		Map<String, Object> response = new HashMap<String, Object>();
		try {
			IUserService iUserService =new UserService();
			User userDetails = iUserService.findUserByUserName(userName);
			if(userDetails == null)
			{
				response.put("Message", "User not found");
				return response;
			}
			else
			{
				response.put("status", 200);
				response.put("data",userDetails);
				response.put("Message","Successfull");
			}
			return response;
		} catch (Exception ex) {
			ex.printStackTrace();
			response.put("Message", "User not found");
			return response;
		}
	}

	@RequestMapping(value = "/findUserById", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> findUserById(@RequestParam("userId") long userId) {
		Map<String, Object> response = new HashMap<String, Object>();
		try {
			IUserService iUserService = new UserService();
			User userDetail = iUserService.findUserById(userId);
			if(userDetail == null)
			{
				response.put("Message", "User not found");
				return response;
			}
			else
			{
				response.put("status", 200);
				response.put("Data",userDetail);
				response.put("Message", "Successful");
			}
			return response;
		} catch (Exception ex) {
			ex.printStackTrace();
			response.put("Message", "User not found");
			return response;
		}
	}
}
