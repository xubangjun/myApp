package com.robot.runnerz.example.user;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.robot.runnerz.example.exception.ErrorStatus;
import com.robot.runnerz.example.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseEntity getUserById(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id, HttpStatus.NOT_FOUND, ErrorStatus.USER_NOT_FOUND));

        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, Object> map = objectMapper.convertValue(user.getData(), Map.class);
        return user.toUserResponseEntity(user);
    }

    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.toEntity(userDto);
        System.out.println("Data type: " + user.getData().getClass().getName());
        User savedUser = userRepository.save(user);
        return UserMapper.toDto(savedUser);
    }

    @Transactional
    public UserDto updateUser(UUID id, UserDto userDto) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id, HttpStatus.NOT_FOUND, ErrorStatus.USER_NOT_FOUND));
        existingUser.setName(userDto.getName());
        existingUser.setEmail(userDto.getEmail());
        User updatedUser = userRepository.save(existingUser);
        return UserMapper.toDto(updatedUser);
    }

    public void deleteUser(UUID id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User not found with id: " + id, HttpStatus.NOT_FOUND, ErrorStatus.USER_NOT_FOUND);
        }
        userRepository.deleteById(id);
    }

    public Page<User> getAllUsers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size); // Create Pageable object
        return userRepository.findAll(pageable); // Fetch paginated results
    }


}
