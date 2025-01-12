package com.robot.runnerz.example.user;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.JsonNode;
import com.robot.runnerz.example.car.Car;
import com.robot.runnerz.example.car.Group;
import com.robot.runnerz.example.utils.JpaConverterJson;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users", schema = "my_schema")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    private UUID id;

    @NotNull
    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(columnDefinition = "jsonb")
    @Convert(converter = JpaConverterJson.class)
    private JsonNode data;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Car> cars;    // Getters and Setters
    // ... JsonManagerReference
    //

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_groups",
            schema = "my_schema",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )

    private Set<Group> groups = new HashSet<>();

    public UserResponseEntity toUserResponseEntity(User user) {

        return  UserResponseEntity.builder().
                id(user.getId()).
                name(user.getName()).
                email(user.getEmail()).
                car(user.getCars()).
                data(user.getData()).
                build();
    }
}
