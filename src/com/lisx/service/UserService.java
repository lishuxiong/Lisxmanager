package com.lisx.service;

import com.lisx.mode.User;

public interface UserService {
	
	public User login(String username,String password);
	
	public boolean register(User user);

}
