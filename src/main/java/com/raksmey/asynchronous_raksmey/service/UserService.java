package com.raksmey.asynchronous_raksmey.service;

import com.raksmey.asynchronous_raksmey.model.User;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface UserService {
    List<User> getListOfUser();
    CompletableFuture<List<User>> getUsersAsync();
}
