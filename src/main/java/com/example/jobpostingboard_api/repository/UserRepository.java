package com.example.jobpostingboard_api.repository;

import com.example.jobpostingboard_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmailAddress(String email);
}
