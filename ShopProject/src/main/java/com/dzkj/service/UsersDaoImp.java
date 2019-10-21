package com.dzkj.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dzkj.mapper.IUsersMapper;
import com.dzkj.pojo.users;
@Service
public class UsersDaoImp implements IUsersDao{
	@Autowired
	private IUsersMapper us;
	
	@Override
	public users login(users u) {
		
		return us.login(u);
	}

	@Override
	public void add(users u) {
		us.add(u);
		
	}

	@Override
	public users selectname(users u) {
		
		return us.selectname(u);
	}

}
