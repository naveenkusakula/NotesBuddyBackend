package com.example.notesbuddy.services;

import org.springframework.stereotype.Service;

import com.example.notesbuddy.model.User;

@Service
public interface IUserService {

	public Long Register(User user);

	public User login(long id);

	public long deleteUser(long UserId);

	public User findUserByUserName(String UserName);

	public User findUserById(long id);

	public long updateUserDetail(long userId, User Loggeduser);

	public long changePassword(long id, User user);
}
