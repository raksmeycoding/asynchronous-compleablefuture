package com.raksmey.asynchronous_raksmey.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class CompletableFutureRunner implements CommandLineRunner {
    private final static Logger logger = LoggerFactory.getLogger(CompletableFutureRunner.class);

    @Override
    public void run(String... args) throws Exception {
        logger.info("Class::CompletableFutureRunner");

    }
}
