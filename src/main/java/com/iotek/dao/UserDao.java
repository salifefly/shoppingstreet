package com.iotek.dao;

import com.iotek.entity.User;

public interface UserDao {

	public User queryByNameAndPwd(String name, String pwd);
}
