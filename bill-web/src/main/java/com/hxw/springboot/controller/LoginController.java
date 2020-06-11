package com.hxw.springboot.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hxw.springboot.interfaces.UserService;
import com.hxw.springboot.pojo.User;
import com.hxw.springboot.uitl.ResponseOutUtil;

@Controller
public class LoginController {

	@Reference
	UserService userService;

	/**
	 * 显示登陆页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogin() {
		System.out.println("进登录了");
		return "login";
	}

	/**
	 * 登陆
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(User user, HttpSession session, HttpServletResponse response) {
		User resultUser = userService.login(user);
		if (resultUser == null) {
			ResponseOutUtil.alert(response, "用户名或密码错误！");
			return "login";
		} else {
			session.setAttribute("user", resultUser);
			ResponseOutUtil.alert(response, "欢迎回来" + resultUser.getuName());
			return "main";
		}
	}
}
