package com.example.demo.cotrollers;

import java.util.List;

import com.example.demo.entity.User;
import com.example.demo.model.dto.UserDto;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository repo;
    private UserService userservice;

    @GetMapping("")
    public ResponseEntity<?> getlistUser() {
        List<UserDto> users = userservice.getListUser();
        List<User> list = (List<User>) repo.findAll();
        System.out.println("Find All : ");

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        return ResponseEntity.ok(userservice.getUserById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchUser(@RequestParam String keyword) {
        List<UserDto> users = userservice.searchUserByName(keyword);
        return ResponseEntity.ok(users);
    }

    @PostMapping("")
    public ResponseEntity<?> createUser() {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser() {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser() {
        return null;
    }

}
