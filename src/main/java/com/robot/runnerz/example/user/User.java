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

import java.util.*;

@Entity
@Table(name = "users", schema = "my_schema")
@Getter
@Setter
@NoArgsConstructor
public class User implements Cloneable, Comparable<User>{

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

    // clone()
    @Override
    public User clone() {
        try {
            User cloned = (User) super.clone();

            if (this.cars != null) {
                cloned.setCars(new HashSet<>());
                for (Car car : this.cars) {
//                    cloned.getCars().add(car.clone());
                }
            }

            if (this.groups != null) {
                cloned.setGroups(new HashSet<>());
                for (Group group : this.groups) {
//                    cloned.getGroups().add(group.clone());
                }
            }

            // deep data
            if (this.data != null) {
                cloned.setData(new HashMap<>(this.data));
            }

            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning not supported", e);
        }
    }

    @Override
    public int compareTo(User other) {
        return this.id.compareTo(other.getId());
    }

    // toString() 方法: 返回 User 对象的字符串表示
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", data=" + data +
                ", cars=" + cars +
                ", groups=" + groups +
                '}';
    }
}
