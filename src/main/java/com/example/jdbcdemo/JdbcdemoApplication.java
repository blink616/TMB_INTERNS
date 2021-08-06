package com.example.jdbcdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JdbcdemoApplication {

	public static void main(String[] args) {
		DBConnection.make_connection();
		SpringApplication.run(JdbcdemoApplication.class, args);
	}

}
