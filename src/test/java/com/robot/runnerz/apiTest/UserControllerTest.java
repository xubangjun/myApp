package com.robot.runnerz.apiTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.robot.runnerz.test.UserController;
import com.robot.runnerz.test.UserDto;
import com.robot.runnerz.test.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserServiceImpl userServiceImpl;

    @Test
    void testGetUserById() throws Exception {
        // Mock 数据
        Long userId = 1L;
        UserDto mockUser = new UserDto(userId, "John Doe", "john.doe@example.com");
        Mockito.when(userServiceImpl.getUserById(userId)).thenReturn(mockUser);

        // 执行测试
        mockMvc.perform(get("/users/{id}", userId)) // 假设你的控制器路径是 "/users"
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(userId))
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.email").value("john.doe@example.com"));
    }
}
