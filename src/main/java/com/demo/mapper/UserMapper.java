package com.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.demo.entity.User;

@Mapper
public interface UserMapper {
	/**
	 * 用户登录
	 * @param loginName
	 * @param password
	 * @return
	 */
	public User login(@Param("loginName")String loginName, @Param("password")String password);

}
