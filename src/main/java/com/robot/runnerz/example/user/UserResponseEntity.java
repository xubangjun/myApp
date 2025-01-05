package com.robot.runnerz.example.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Builder
public class UserResponseEntity {
    private Long id;
    private String name;

    private String email;
}
