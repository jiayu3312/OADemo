package com.demo.service;

import com.demo.entity.User;

/**
 * 用户相关接口
 * @author 叶金雄
 * @date 2019年1月23日 下午3:08:05
 */
public interface UserService {
	
	//登录
	public User login(String loginName, String password);
	
}
