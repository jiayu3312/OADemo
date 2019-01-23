package com.demo.service.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.User;
import com.demo.mapper.UserMapper;
import com.demo.service.UserService;


/**
 * 用户实现类
 * @author 叶金雄
 * @date 2019年1月23日 下午3:09:50
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	//登录
	@Override
	public User login(String loginName, String password) {
		return userMapper.login(loginName, password);
	}

}
