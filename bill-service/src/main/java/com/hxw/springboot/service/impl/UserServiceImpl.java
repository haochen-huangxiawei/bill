package com.hxw.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hxw.springboot.dao.UserMapper;
import com.hxw.springboot.interfaces.UserService;
import com.hxw.springboot.pojo.User;

@com.alibaba.dubbo.config.annotation.Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	public int insert(User record) {
		// TODO Auto-generated method stub
		return userMapper.insert(record);
	}

	public int insertSelective(User record) {
		// TODO Auto-generated method stub
		return userMapper.insertSelective(record);
	}

	public User login(User user) {
		// TODO Auto-generated method stub
		return userMapper.login(user);
	}

	public List<User> showAllUser(String usrName) {
		// TODO Auto-generated method stub
		return userMapper.showAllUser(usrName);
	}

	public User queryUser(String uName) {
		// TODO Auto-generated method stub
		return userMapper.queryUser(uName);
	}

	public int updateByPrimaryKeySelective(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateByPrimaryKeySelective(user);
	}

	public User queryPwd(User user) {
		// TODO Auto-generated method stub
		return userMapper.queryPwd(user);
	}
}