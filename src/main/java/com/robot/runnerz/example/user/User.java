package com.robot.runnerz.example.user;

import com.robot.runnerz.example.car.Car;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "users", schema = "my_schema")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;


    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Car> cars;    // Getters and Setters
    // ... JsonManagerReference
    //
}
