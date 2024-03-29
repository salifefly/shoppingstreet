package com.iotek.service.impl;

import com.iotek.dao.UserDao;
import com.iotek.dao.impl.UserDaoImpl;
import com.iotek.entity.User;
import com.iotek.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();

	@Override
	public User queryByNameAndPwd(String name, String pwd) {
		return userDao.queryByNameAndPwd(name, pwd);
	}

}
