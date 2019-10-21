package com.dzkj.mapper;


import org.apache.ibatis.annotations.Param;

import com.dzkj.pojo.users;

public interface IUsersMapper {
	users login(users u);
	void add(users u);
	users selectname(users u);
}
