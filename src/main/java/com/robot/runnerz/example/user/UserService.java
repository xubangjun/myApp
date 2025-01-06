package com.robot.runnerz.example.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserResponseEntity getUserById(Long id);

    UserDto createUser(UserDto userDto);

    UserDto updateUser(Long id, UserDto userDto);

    void deleteUser(Long id);

    Page<User> getAllUsers(int page, int size);
}
