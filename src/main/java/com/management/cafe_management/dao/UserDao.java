package com.management.cafe_management.dao;

import com.management.cafe_management.POJO.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserDao extends JpaRepository<User,Integer> {
//  User findByEmailId(@Param("email") String email);
Optional<User> findByEmailId(String email);
}
