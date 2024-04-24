package com.yuv.microservicesBasics.usersMicroservice.User.service;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.yuv.microservicesBasics.usersMicroservice.User.dto.UserDto;
import com.yuv.microservicesBasics.usersMicroservice.User.entity.UserEntity;
import com.yuv.microservicesBasics.usersMicroservice.User.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	UserRepo repo;
	BCryptPasswordEncoder encoder;

	@Autowired
	public UserServiceImpl(UserRepo repo,BCryptPasswordEncoder encoder) {
		super();
		this.repo = repo;
		this.encoder=encoder;
	}

	@Override
	public UserDto createUser(UserDto userDetails) {
		userDetails.setUserId(UUID.randomUUID().toString());
		userDetails.setEncryptedPassword(encoder.encode(userDetails.getPassword()));
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity user = mapper.map(userDetails, UserEntity.class);
		UserEntity response = repo.save(user);
		UserDto res = mapper.map(response, UserDto.class);
		return res;
	}

}
