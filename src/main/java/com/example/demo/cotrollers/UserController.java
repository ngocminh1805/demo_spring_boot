package com.example.demo.cotrollers;

import java.util.List;

import com.example.demo.entity.User;
import com.example.demo.model.dto.UserDto;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userservice;

    @GetMapping("")
    public ResponseEntity<?> getlistUser(@RequestParam int page, int limit) {
        List<UserDto> users = userservice.getListUser(page, limit);
        // List<User> list = (List<User>) repo.findAll();
        System.out.println("Find All : ");

        return ResponseEntity.ok(users);
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
    public UserDto createUser(@RequestBody User user) {
        System.out.println("BODY : " + user.toString());
        UserDto result = userservice.createUser(user);
        return result;
    }

    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable int id, @RequestBody User user) {
        UserDto result = userservice.updateUser(id, user);
        return result;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        userservice.deleteUser(id);
        return ResponseEntity.ok("sucess");
    }

}
