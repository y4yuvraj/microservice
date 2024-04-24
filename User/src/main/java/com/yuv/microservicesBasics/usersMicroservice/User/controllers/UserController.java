package com.yuv.microservicesBasics.usersMicroservice.User.controllers;

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

import com.yuv.microservicesBasics.usersMicroservice.User.dto.UserDto;
import com.yuv.microservicesBasics.usersMicroservice.User.model.CreateUserRequestModel;
import com.yuv.microservicesBasics.usersMicroservice.User.model.CreateUserResponseModel;
import com.yuv.microservicesBasics.usersMicroservice.User.service.UserServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	Environment env;

	@Autowired
	UserServiceImpl service;

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
