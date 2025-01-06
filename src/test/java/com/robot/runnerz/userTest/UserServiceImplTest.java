package com.robot.runnerz.userTest;

import com.robot.runnerz.example.exception.ResourceNotFoundException;
import com.robot.runnerz.example.user.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void testGetUserById_UserExists() {
        // Mock user data
        Long userId = 1L;
        User mockUser = new User();
        mockUser.setId(userId);
        mockUser.setName("John Doe");
        mockUser.setEmail("john.doe@example.com");

        // Mock repository behavior
        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(mockUser));

        // Call the method under test
        UserResponseEntity userDto = userService.getUserById(userId);

        // Assertions
        assertNotNull(userDto);
        assertEquals(userId, userDto.getId());
        assertEquals("John Doe", userDto.getName());
        assertEquals("john.doe@example.com", userDto.getEmail());

        // Verify repository interaction
        Mockito.verify(userRepository, Mockito.times(1)).findById(userId);
    }

    @Test
    public void testGetUserById_UserNotFound() {
        // Mock user ID
        Long userId = 2L;

        // Mock repository behavior
        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.empty());

        // Call the method and assert exception
        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> {
            userService.getUserById(userId);
        });

        // Verify exception message
        assertEquals("User not found with id: 2", exception.getMessage());

        // Verify repository interaction
        Mockito.verify(userRepository, Mockito.times(1)).findById(userId);
    }
}
