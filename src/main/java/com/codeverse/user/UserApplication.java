package com.codeverse.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserApplication {

	public static void main(String[] args) {

		int []a = {1,2,3};
		int b[];
		b=a;
		SpringApplication.run(UserApplication.class, args);
	}

}
