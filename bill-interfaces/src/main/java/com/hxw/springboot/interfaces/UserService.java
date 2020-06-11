package com.hxw.springboot.interfaces;

import java.util.List;

import com.hxw.springboot.pojo.User;

public interface UserService {
	int insert(User record);

	int insertSelective(User record);

	/**
	 * 登陆
	 */
	User login(User user);

	/**
	 * 显示所有用户信息
	 */
	List<User> showAllUser(String usrName);

	/**
	 * 根据用户名查询当前用户信息
	 */
	User queryUser(String uName);

	/**
	 * 修改用户
	 */
	int updateByPrimaryKeySelective(User user);

	/**
	 * 判断用户输入密码是否正确
	 */
	User queryPwd(User user);
}