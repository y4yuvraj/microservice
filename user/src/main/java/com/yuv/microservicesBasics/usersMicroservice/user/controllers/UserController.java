package com.yuv.microservicesBasics.usersMicroservice.user.controllers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yuv.microservicesBasics.usersMicroservice.user.dto.UserDto;
import com.yuv.microservicesBasics.usersMicroservice.user.model.CreateUserRequestModel;
import com.yuv.microservicesBasics.usersMicroservice.user.model.CreateUserResponseModel;
import com.yuv.microservicesBasics.usersMicroservice.user.service.UserServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

	Environment env;
	UserServiceImpl service;

	@Autowired
	public UserController(Environment env, UserServiceImpl service) {
		this.env = env;
		this.service = service;
	}

	@GetMapping("/status/check")
	public String status() {
		return "Hello " + env.getProperty("local.server.port");
	}

	@PostMapping
	public ResponseEntity<CreateUserResponseModel> createUser(@RequestBody @Valid CreateUserRequestModel user) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto userDetails = mapper.map(user, UserDto.class);
		UserDto createdUser = service.createUser(userDetails);
		CreateUserResponseModel response = mapper.map(createdUser, CreateUserResponseModel.class);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

}
