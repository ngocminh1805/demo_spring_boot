package com.example.demo.model.dto;

import java.util.List;

public class UserDto {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String avatar;
    private List<CarDto> cars;

    public UserDto() {
    }

    public UserDto(int id, String name, String email, String phone, String avatar, List<CarDto> cars) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.avatar = avatar;
        this.cars = cars;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<CarDto> getCars() {
        return this.cars;
    }

    public void setCars(List<CarDto> cars) {
        this.cars = cars;
    }

}
