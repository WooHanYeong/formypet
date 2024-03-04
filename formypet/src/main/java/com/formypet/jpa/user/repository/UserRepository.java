package com.formypet.jpa.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formypet.jpa.user.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUsername(String username);
}