package com.dzkj.service;

import com.dzkj.pojo.users;

public interface IUsersDao {
	users login(users u);
	void add(users u);
	users selectname(users u);
}
