package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.name like %?1%")
    List<User> findUserByName(String keyword);

}
