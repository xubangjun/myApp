package com.robot.runnerz.example.user;

import com.fasterxml.jackson.databind.JsonNode;

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
        user.setCars(dto.getCar());
        user.setData(dto.getData());
        return user;
    }
}