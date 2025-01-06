package com.robot.runnerz.example.car;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.robot.runnerz.example.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "groups", schema = "my_schema")
@Getter
@Setter
@NoArgsConstructor
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "groups", fetch = FetchType.EAGER)
    @JsonIgnore// 由 User 的关系维护
    private Set<User> users = new HashSet<>();
}

