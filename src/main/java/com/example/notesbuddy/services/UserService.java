//<!-- Author: Dhruvi Shah -->
package com.example.notesbuddy.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.notesbuddy.database.UserDataServices;
import com.example.notesbuddy.model.User;

@Service
public class UserService implements IUserService {
	@Override
	public Long Register(User RegisteringUser) {
		long userId = 0;
		try {

			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(RegisteringUser.getPassword());
			RegisteringUser.setPassword(hashedPassword);
			userId = UserDataServices.addUser(RegisteringUser);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return userId;
	}

	@Override
	public User login(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long deleteUser(long userId) {
		try {
			userId = UserDataServices.deleteUserById(userId);
			return userId;
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	@Override
	public long updateUserDetail(long userId, User Loggeduser) {
		try {
			userId = UserDataServices.updateUserDetail(userId, Loggeduser);
			return userId;
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	@Override
	public User findUserByUserName(String UserName) {
		try {
			User userDetails = UserDataServices.findUserByName(UserName);
			return userDetails;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public User findUserById(long UserId) {
		try {
			User userDetails = UserDataServices.findUserById(UserId);
			return userDetails;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public long changePassword(long id, User user) {
		// TODO Auto-generated method stub
		return 0;
	}

}
