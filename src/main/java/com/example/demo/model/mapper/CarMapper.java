package com.example.demo.model.mapper;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.Car;
import com.example.demo.model.dto.CarDto;

public class CarMapper {
    public static List<CarDto> toCarDto(List<Car> cars) {
        List<CarDto> tmp = new ArrayList<CarDto>();
        for (Car car : cars) {
            CarDto tmpCar = new CarDto();
            tmpCar.setBrand(car.getBrand());
            tmpCar.setId(car.getId());
            tmpCar.setName(car.getName());
            tmp.add(tmpCar);
        }
        return tmp;

    }
}
