package com.ngash.javatechie.ExceptionHandling.repository;

import com.ngash.javatechie.ExceptionHandling.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByUserId(int id);
    public List<User> findByNameIgnoreCase(String name);
}



