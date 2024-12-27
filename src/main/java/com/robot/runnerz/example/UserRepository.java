package com.robot.runnerz.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // 你可以在这里添加自定义查询方法
    Optional<User> findByEmail(String email);
}
