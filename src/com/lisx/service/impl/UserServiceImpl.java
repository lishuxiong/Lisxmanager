package com.lisx.service.impl;

import com.lisx.dao.UserDao;
import com.lisx.dao.impl.UserDaoImpl;
import com.lisx.mode.User;
import com.lisx.service.UserService;

public class UserServiceImpl implements UserService {

	UserDao userDao = new UserDaoImpl();

	@Override
	public User login(String username, String password) {
		User user = userDao.getUserByUsernameAndPassword(username, password);
		return user;
	}

	@Override
	public boolean register(User user) {
		User u = userDao.getUserByUsername(user.getUsername());
		System.out.println("lisx : " + user.getUsername());
		System.out.println("lisx : " + u);
		if (u == null) {
			userDao.addUser(user);
			return true;
		}
		return false;
	}

}
