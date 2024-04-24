package com.yuv.microservicesBasics.usersMicroservice.User.service;

import com.yuv.microservicesBasics.usersMicroservice.User.dto.UserDto;

public interface UserService {

	UserDto createUser(UserDto userDetails);
	
}
