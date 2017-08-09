package com.lisx.test;

import java.util.Date;

import org.junit.Test;

import com.lisx.dao.UserDao;
import com.lisx.dao.impl.UserDaoImpl;
import com.lisx.mode.User;

public class JTestUtil {

	UserDao dao  = new UserDaoImpl();
	@Test
	public void test1(){
		User user = dao.getUserByUsername("tt");
		System.out.println(user);
	}
	
	@Test
	public void test2(){
		User user = dao.getUserByUsernameAndPassword("tt2", "888");
		System.out.println(user);
	}
	
	@Test
	public void test3(){
		User user =  new User("xhj","888","tj@163.com",new Date());
		dao.addUser(user);
	}
}
