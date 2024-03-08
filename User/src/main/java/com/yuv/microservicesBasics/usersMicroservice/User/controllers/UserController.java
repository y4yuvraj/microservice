package com.yuv.microservicesBasics.usersMicroservice.User.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	@GetMapping("/status/check")
	public String status()
	{
		return "Hello";
	}
	
}
