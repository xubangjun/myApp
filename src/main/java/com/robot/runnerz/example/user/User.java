package com.robot.runnerz.example.user;
import org.hibernate.annotations.Type;
import com.fasterxml.jackson.databind.JsonNode;
import com.robot.runnerz.example.car.Car;
import com.robot.runnerz.example.car.Group;
import com.robot.runnerz.example.utils.JpaConverterJson;
import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.HashSet;
import java.util.Map;
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
    @Type(JsonType.class)
//    private JsonNode data;
    private Map<String, Object> data;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
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
        Set<Car> cars = user.getCars();
        if (cars != null) {
            for (Car car : cars) {
                car.setUser(this);
                car.setId(UUID.randomUUID());
            }
        }

        return  UserResponseEntity.builder().
                id(user.getId()).
                name(user.getName()).
                email(user.getEmail()).
                car(cars).
                data(user.getData()).
                groups(user.getGroups()).
                build();
    }
}
