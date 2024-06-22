package com.raksmey.asynchronous_raksmey.model;


import lombok.*;
import org.springframework.scheduling.annotation.Async;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class User {
    private Long id;
    private String name;

    private User(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    @Async
    public static List<User> getUserInstandAsList() {
        List<User> userList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            User user = User.builder()
                    .id((long) i)
                    .name("username" + i)
                    .build();

            userList.add(user);
        }

        return userList;
    }
}
