package com.robot.runnerz.example.user;

import com.robot.runnerz.example.car.Car;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private Long id;
    private String name;

    private String email;

    private Set<Car> car;

    // Getters and Setters
    // ...
}


