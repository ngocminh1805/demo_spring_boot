package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.User;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.mapper.UserMapper;
import com.example.demo.repository.UserRepository;

import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    private static ArrayList<User> users = new ArrayList<User>();
    private UserRepository repo;

    static {
        users.add(new User(1, "Nguyen Ngoc Minh", "ngocminh180599@gmail.com", "0338759771", "/avatar/1.png", "123456"));
        users.add(
                new User(2, "Pham Thi Thanh Van", "phamtthnahvan@gmail.com", "0123456789", "/avatar/2.png", "123456"));
        users.add(
                new User(3, "Nguyen Thi Phuong Thao", "phuongthao@gmail.com", "0987654321", "/avatar/3.png", "123456"));
        users.add(new User(4, "Trinh Xuan Tung", "xuantung1702@gmail.com", "0678912345", "/avatar/4.png", "123456"));
        users.add(new User(5, "Le Minh Chau", "chaulm0609@gmail.com", "0123987654", "/avatar/5.png", "123456"));
        users.add(new User(6, "Tran Tien Sy", "trantiensy@gmail.com", "0987234651", "/avatar/6.png", "123456"));
        users.add(new User(7, "Pham Tien Viet", "phamtienviet@gmail.com", "0456123987", "/avatar/7.png", "123456"));
    }

    @Override
    public List<UserDto> getListUser() {
        List<UserDto> result = new ArrayList<UserDto>();
        for (User user : users) {
            result.add(UserMapper.toUserDto(user));
        }
        return result;
    }

    @Override
    public UserDto getUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return UserMapper.toUserDto(user);
            }
        }
        return null;
    }

    @Override
    public List<UserDto> searchUserByName(String keyword) {
        List<UserDto> result = new ArrayList<UserDto>();
        for (User user : users) {
            if (user.getName().contains(keyword)) {
                result.add(UserMapper.toUserDto(user));
            }
        }
        return result;
    }

}
