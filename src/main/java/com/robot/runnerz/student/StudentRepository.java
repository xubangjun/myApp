package com.robot.runnerz.student;

import com.robot.runnerz.example.Student;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface StudentRepository extends MongoRepository<Student, String> {
}
