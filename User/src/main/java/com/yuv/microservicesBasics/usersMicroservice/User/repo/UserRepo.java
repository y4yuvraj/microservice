package com.yuv.microservicesBasics.usersMicroservice.User.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yuv.microservicesBasics.usersMicroservice.User.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Long> {

}
