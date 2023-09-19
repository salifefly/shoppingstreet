package com.iotek.service;

import com.iotek.entity.User;

public interface UserService {
	public User queryByNameAndPwd(String name, String pwd);
}
