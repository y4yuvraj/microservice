package com.yuv.microservicesBasics.usersMicroservice.user.service;

import com.yuv.microservicesBasics.usersMicroservice.user.dto.UserDto;

public interface UserService {

	UserDto createUser(UserDto userDetails);
	
}
