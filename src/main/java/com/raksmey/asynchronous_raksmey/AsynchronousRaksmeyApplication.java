package com.raksmey.asynchronous_raksmey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class AsynchronousRaksmeyApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsynchronousRaksmeyApplication.class, args);
	}

}
