package com.yuv.microservicesBasics.usersMicroservice.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yuv.microservicesBasics.usersMicroservice.user.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Long> {

}
