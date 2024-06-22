package com.raksmey.asynchronous_raksmey.service;


import com.raksmey.asynchronous_raksmey.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public List<User> getListOfUser() {
        logger.info("===UserServiceImpl;Thread name::{}===", Thread.currentThread().getName());
        return User.getUserInstandAsList();
    }


    @Override
    @Async
    public CompletableFuture<List<User>> getUsersAsync() {
        logger.info("===UserServiceImpl;CompletableFuture;Thread name::{}===", Thread.currentThread().getName());
        return CompletableFuture.completedFuture(User.getUserInstandAsList());
    }
}
