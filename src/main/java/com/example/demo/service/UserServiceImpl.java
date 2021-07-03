package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.User;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.mapper.UserMapper;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDto> getListUser(int page, int limit) {
        long count = userRepository.count();
        int firtPositon = (page - 1) * limit;

        List<User> users = userRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
        List<UserDto> result = new ArrayList<UserDto>();
        for (User user : users) {
            result.add(UserMapper.toUserDto(user));
        }
        return result;
    }

    @Override
    public UserDto getUserById(int id) {
        User user = userRepository.getById(id);
        return UserMapper.toUserDto(user);
    }

    @Override
    public List<UserDto> searchUserByName(String keyword) {
        List<User> users = userRepository.findAll();
        List<UserDto> result = new ArrayList<UserDto>();
        for (User user : users) {
            if (user.getName().contains(keyword)) {
                result.add(UserMapper.toUserDto(user));
            }
        }
        return result;
    }

    @Override
    public UserDto createUser(User user) {
        userRepository.save(user);
        return UserMapper.toUserDto(user);
    }

    @Override
    public UserDto updateUser(int id, User user) {
        user.setId(id);
        userRepository.save(user);
        return UserMapper.toUserDto(user);
    }

    @Override
    public void deleteUser(int id) {
        // TODO Auto-generated method stub
        userRepository.deleteById(id);
    }

}
