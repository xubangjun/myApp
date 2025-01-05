package com.robot.runnerz.example.student;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "student")
@Getter
@Setter
@NoArgsConstructor
public class Student {

    @Id
    private String id;
    private String name;
    private int age;
    private String major;
}
