package com.demo.service.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mapper.TestMapper;
import com.demo.service.TestService;

@Service
public class TestServiceImp implements TestService {
	
	@Autowired
	private TestMapper testMapper;

	@Override
	public String test() {

		return testMapper.test();
	}

}
