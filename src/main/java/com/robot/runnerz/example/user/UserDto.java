package com.robot.runnerz.example.user;

import com.fasterxml.jackson.databind.JsonNode;
import com.robot.runnerz.example.car.Car;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private UUID id;
    private String name;

    private String email;

    private Set<Car> car;

//    private JsonNode data;

    private Map data;

    // Getters and Setters
    // ...
}


