package com.robot.runnerz.example.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student) {
        return studentRepository.save(student);  // 保存 Student 实体
    }

    // 你还可以添加更多的服务方法，例如查询、更新等
}
