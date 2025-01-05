package com.robot.runnerz.example.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // 你可以在这里添加自定义查询方法
    Optional<User> findByEmail(String email);

//    @Query("SELECT u FROM User u LEFT JOIN FETCH u.cars WHERE u.id = :userId")
//    Optional<User> findUserWithCars(@Param("userId") Long userId);
}
