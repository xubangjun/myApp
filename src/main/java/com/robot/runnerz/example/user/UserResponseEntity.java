package com.robot.runnerz.example.user;

import com.fasterxml.jackson.databind.JsonNode;
import com.robot.runnerz.example.car.Car;
import com.robot.runnerz.example.car.Group;
import lombok.*;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class UserResponseEntity {
    private UUID id;

    private String name;

    private String email;

    private Set<Car> car;

//    private JsonNode data;

    private Set<Group>  groups;

    private Map data;
}
