package com.robot.runnerz.example.user;

import com.fasterxml.jackson.databind.JsonNode;
import com.robot.runnerz.example.car.Car;

import java.util.Set;
import java.util.UUID;

public class UserMapper {
    public static UserDto toDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        return dto;
    }

    public static User toEntity(UserDto dto) {
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        Set<Car> cars = dto.getCar();
        for (Car car : cars) {
            // 给每个 Car 设置 userId
            car.setId(UUID.randomUUID());
            car.setUser(user);
        }
        user.setCars(cars);
        user.setData(dto.getData());
        return user;
    }
}