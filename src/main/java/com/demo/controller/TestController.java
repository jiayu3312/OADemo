package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service.TestService;

@RestController
@RequestMapping(path = "/test", produces = { "application/json;charset=UTF-8" })
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@GetMapping("/test")
	public String test() {

		return testService.test();
	}
}
