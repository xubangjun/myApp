package com.robot.runnerz.example.user;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestEntity {
    @NotNull
    private Long id;
    private String name;
    private String email;
    private Map<String, Object> data;
}
