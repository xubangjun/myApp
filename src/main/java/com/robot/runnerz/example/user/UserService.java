package com.robot.runnerz.example.user;

public interface UserService {

    UserResponseEntity getUserById(Long id);

    UserDto createUser(UserDto userDto);

    UserDto updateUser(Long id, UserDto userDto);

    void deleteUser(Long id);
}
