package com.robot.runnerz.example.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface UserService {

    UserResponseEntity getUserById(UUID id);

    UserDto createUser(UserDto userDto);

    UserDto updateUser(UUID id, UserDto userDto);

    void deleteUser(UUID id);

    Page<User> getAllUsers(int page, int size);
}
