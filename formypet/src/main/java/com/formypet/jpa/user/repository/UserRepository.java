package com.formypet.jpa.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.formypet.jpa.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT u.user_id FROM userinfo u WHERE u.user_name = :user_name and u.user_birth_date = :user_birth_date", nativeQuery = true)
    String findUserIdByUserNameAndBirthDate(@Param("user_name") String userName, @Param("user_birth_date") String userBirthDate);

    @Query(value = "SELECT u.user_password FROM userinfo u WHERE u.user_id = :user_id and u.user_name = :user_name and u.user_birth_date = :user_birth_date", nativeQuery = true)
    String findUserPasswordByUserIdNameAndBirthDate(@Param("user_id") String userId, @Param("user_name") String userName, @Param("user_birth_date") String userBirthDate);

    void deleteByUserId(String userId);
    
    User findByUserId(String userId);
    
    boolean existsByUserId(String userId);
}