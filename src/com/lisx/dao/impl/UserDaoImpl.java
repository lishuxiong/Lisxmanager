package com.lisx.dao.impl;

import java.util.Date;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.dom4j.Document;
import org.dom4j.Node;

import com.lisx.dao.UserDao;
import com.lisx.mode.User;
import com.lisx.util.Dom4jUtil;

public class UserDaoImpl implements UserDao{

	
	@Override
	public User getUserByUsername(String username) {
		User user = null;
		try {
			Document document = Dom4jUtil.getDocument();
			Node element = document.selectSingleNode("//user[@username='"+username+"']");
			if(element != null ){
			   user = new User();
			   user.setUsername(element.valueOf("@username"));
			   user.setPassword(element.valueOf("@password"));
			   user.setEmail(element.valueOf("@email"));
			   String birthday= element.valueOf("@birthday");
			   DateLocaleConverter converter = new DateLocaleConverter();
			   user.setBirthday((Date)converter.convert(birthday, "yyyy-MM-dd"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public User getUserByUsernameAndPassword(String username, String password) {
		User user = null;
		try {
			Document document  = Dom4jUtil.getDocument();
			Node element = document.selectSingleNode("//user[@username='"+username+"' and @password='"+password+"']");
			if(element !=null){
				user = new User();
				user.setUsername(element.valueOf("@username"));
				user.setPassword(element.valueOf("@password"));
				user.setEmail(element.valueOf("@email"));
				String birthday= element.valueOf("@birthday");
				//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				//format.parse(birthday)
				DateLocaleConverter convert = new DateLocaleConverter();
				user.setBirthday((Date)convert.convert(birthday, "yyyy-MM-dd"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public void addUser(User user) {
		try {
			Document document = Dom4jUtil.getDocument();
			document.getRootElement()
			.addElement("user")
			.addAttribute("username", user.getUsername())
			.addAttribute("password", user.getPassword())
			.addAttribute("email", user.getEmail())
			.addAttribute("birthday", user.getBirthday().toLocaleString());
			 Dom4jUtil.writeDocument2XML(document);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
