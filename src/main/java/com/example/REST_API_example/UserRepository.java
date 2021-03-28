package com.example.REST_API_example;

import com.example.REST_API_example.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    //here 'username' field should present in User Model class
    Optional<User> findByusername(String username);
}
