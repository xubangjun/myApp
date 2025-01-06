package com.robot.runnerz.example.user;

import com.fasterxml.jackson.databind.JsonNode;
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

    private JsonNode data;
}
