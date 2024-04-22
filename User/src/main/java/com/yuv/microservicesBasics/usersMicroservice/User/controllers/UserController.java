package com.yuv.microservicesBasics.usersMicroservice.User.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	Environment env;
	
	@GetMapping("/status/check")
	public String status()
	{
		return "Hello "+env.getProperty("local.server.port");
	}
	
}
