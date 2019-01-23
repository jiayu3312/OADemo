package com.demo.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.entity.User;
import com.demo.service.UserService;

/**
 * 用户控制器层
 * 
 * @author 叶金雄
 * @date 2019年1月23日 下午3:12:07
 */
@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	/**
	 * 用户登录
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping("/login")
	@ResponseBody
	public String login(User user, Model model) {
		// 连接数据库进行查询
		User user2 = userService.login(user.getLoginName(), user.getPassword());
		// 对查询结果进行判断
		if (user2 == null) {
			// 登录失败--请求转发
			model.addAttribute("fail", "用户名或密码错误");
//			return "forward:login.jsp";
			return "用户名或密码错误";	//用于测试
		} else {
			// 4.登录成功--响应重定向
			model.addAttribute("success", user);
//			return "index";
			return "恭喜您，登录成功！";	//用于测试
		}
	}
}
