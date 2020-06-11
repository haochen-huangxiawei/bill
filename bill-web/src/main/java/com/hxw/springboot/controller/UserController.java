package com.hxw.springboot.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hxw.springboot.interfaces.UserService;
import com.hxw.springboot.pojo.User;

@Controller
public class UserController {

	@Reference
	UserService userService;

	/**
	 * 显示所有用户信息
	 * 
	 * @param usrName
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String showAllUser(String usrName, Model model) {
		if (usrName == null || usrName == "") {
			usrName = null;
		}

		List<User> userList = userService.showAllUser(usrName);

		model.addAttribute("userList", userList);
		return "showAllUser";
	}

	/**
	 * 显示添加用户页面
	 */
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String addGoUser() {
		return "addUser";
	}

	/**
	 * 添加用户
	 */
	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	public String addUser(User user) {
		try {
			int result = userService.insertSelective(user);
			if (result > 0) {
				System.out.println("添加用户成功！");
			} else {
				System.out.println("添加用户失败！");
			}
		} catch (Exception e) {
			System.out.println("用户名重复");
		}
		return "redirect:user";
	}

	/**
	 * 根据用户名显示当前用户信息
	 */
	@RequestMapping(value = "/user/{uName}", method = RequestMethod.DELETE)
	public String updateShowSupplier(@PathVariable String uName, Model model) {
		/* 根据用户名显示当前用户信息 */
		User user = userService.queryUser(uName);
		model.addAttribute("user", user);
		return "updateUser";
	}

	/**
	 * 修改用户
	 */
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String updateSupplier(User user) {
		int result = userService.updateByPrimaryKeySelective(user);

		if (result > 0) {
			System.out.println("修改用户成功！");
		} else {
			System.out.println("修改用户失败！");
		}
		return "redirect:user";
	}

	/**
	 * 显示修改密码页面
	 */
	@RequestMapping(value = "/userPwd", method = RequestMethod.GET)
	public String showUpdatePwd(String uName, Model model) {
		model.addAttribute("uName", uName);
		return "updateUserPwd";
	}

	/**
	 * 修改密码
	 */
	@RequestMapping(value = "/userPwd", method = RequestMethod.POST)
	public String updatePwdSupplier(User user, String pwd) {
		System.out.println(user.getuPwd());
		System.out.println(pwd);
		/* 根据用户名和原密码是否输入正确 */
		User result = userService.queryPwd(user);
		if (result != null) {
			/* 如果密码输入正确则进行修改 */
			User userPwd = new User(user.getuName(), pwd);
			int results = userService.updateByPrimaryKeySelective(userPwd);

			if (results > 0) {
				System.out.println("修改用户密码成功！");
			} else {
				System.out.println("修改用户密码失败！");
			}
		} else {
			/* 密码错误则给出相应的提示 */
			System.out.println("密码输入错误");
		}
		return "redirect:user";
	}
}
