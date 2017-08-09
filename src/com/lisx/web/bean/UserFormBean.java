package com.lisx.web.bean;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class UserFormBean {

	private String username;
	private String password;
	private String repass;
	private String email;
	private String birthday;

	private Map<String, String> errorMsg = new HashMap<String, String>();

	public boolean validation() {
		if (username == null || "".equals(username)) {
			errorMsg.put("username", "用戶名不能为空!");
		} else {
			if (!username.matches("^[a-zA-Z]{3,8}$")) {
				errorMsg.put("username", "用户名为3-8个字符或字母!");
			}
		}

		if (password == null || "".equals(password)) {
			errorMsg.put("password", "密码不能为空");
		} else {
			if (!password.matches("^[0-9]{3,8}$")) {
				errorMsg.put("password", "密码为长度为3-8个字符且为纯数字");
			}
		}

		if (!password.equals(repass)) {
			errorMsg.put("repass", "两次输入密码不一致");
		}

		if (email == null || email.equals("")) {
			errorMsg.put("email", "邮箱地址不能为空");
		} else {
			if (!email.matches(
					"\\b^['_a-z0-9-\\+]+(\\.['_a-z0-9-\\+]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*\\.([a-z]{2}|aero|arpa|asia|biz|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|nato|net|org|pro|tel|travel|xxx)$\\b")) {
				errorMsg.put("email", "邮箱格式不对，请重新输入");
			}
		}

  		if (birthday == null || birthday.equals("")) {
			errorMsg.put("birthday", "生日不能为空");
		} else {
			try {
				/*
				 * SimpleDateFormat format = new SimpleDateFormat();
				 * format.parse(birthday);
				 */
				DateLocaleConverter convert = new DateLocaleConverter();
				convert.convert(birthday);
			} catch (Exception e) {
				errorMsg.put("birthday", "生日时间不对");
			}
		}

		return errorMsg.isEmpty();
	}

	public UserFormBean() {
		super();
	}

	public UserFormBean(String username, String password, String repass, String email, String birthday) {
		super();
		this.username = username;
		this.password = password;
		this.repass = repass;
		this.email = email;
		this.birthday = birthday;
	}

	public Map<String, String> getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(Map<String, String> errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepass() {
		return repass;
	}

	public void setRepass(String repass) {
		this.repass = repass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
}
