package com.robot.runnerz.example.user;

import com.robot.runnerz.example.car.Car;
import lombok.*;

import java.util.Set;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class UserResponseEntity {
    private Long id;

    private String name;

    private String email;

    private Set<Car> car;
}
