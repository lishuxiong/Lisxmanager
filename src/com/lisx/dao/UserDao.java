package com.lisx.dao;

import com.lisx.mode.User;

public interface UserDao {
	
	/**
	 * 根据用户名得到用户
	 * @param username 用户名
	 * @return
	 */
	public User getUserByUsername(String username);
	
	/**
	 * 根据用户名和密码得到用户
	 * @param username 用户名
	 * @param password 密码
	 * @return
	 */
	public User getUserByUsernameAndPassword(String username,String password);
	
	
	/**
	 * 添加用户信息到user.xml中
	 * @param user
	 */
	public void addUser(User user);

}
