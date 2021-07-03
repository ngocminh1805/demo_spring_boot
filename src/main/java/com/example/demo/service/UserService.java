package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;
import com.example.demo.model.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public List<UserDto> getListUser(int page, int limit);

    public UserDto getUserById(int id);

    public List<UserDto> searchUserByName(String keyword);

    public UserDto createUser(User user);

    public UserDto updateUser(int id, User user);

    public void deleteUser(int id);

}
