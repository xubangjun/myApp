package com.robot.runnerz.apiTest;

import com.robot.runnerz.test.ResourceNotFoundException;
import com.robot.runnerz.test.UserController;
import com.robot.runnerz.test.UserDto;
import com.robot.runnerz.test.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void testGetUserById_UserExists() throws Exception {
        // Mock user data
        Long userId = 1L;
        UserDto mockUserDto = new UserDto();
        mockUserDto.setId(userId);
        mockUserDto.setName("John Doe");
        mockUserDto.setEmail("john.doe@example.com");

        // Mock service behavior
        Mockito.when(userService.getUserById(userId)).thenReturn(mockUserDto);

        // Perform GET request
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users/{id}", userId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(userId))
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.email").value("john.doe@example.com"));

        // Verify service interaction
        Mockito.verify(userService, Mockito.times(1)).getUserById(userId);
    }

}
