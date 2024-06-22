package com.raksmey.asynchronous_raksmey.controller;


import com.raksmey.asynchronous_raksmey.model.User;
import com.raksmey.asynchronous_raksmey.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/userList")
    public ResponseEntity<List<User>> getListOfUser() {
        logger.info("===UserController;Thread name::{}===", Thread.currentThread().getName());
        return ResponseEntity.ok().body(userService.getListOfUser());
    }


    @GetMapping("/async/userList")
    public CompletableFuture<ResponseEntity<List<User>>> asyncListOfUser() {
        logger.info("===UserController;CompletableFuture;Thread name::{}===", Thread.currentThread().getName());
        return userService.getUsersAsync()
                .thenApply(user -> ResponseEntity.ok().body(user))
                .exceptionally(ex -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }
}
