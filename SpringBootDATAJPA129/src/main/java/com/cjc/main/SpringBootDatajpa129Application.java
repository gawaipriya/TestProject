package com.cjc.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan
@EnableJpaRepositories
public class SpringBootDatajpa129Application {

	public static void main(String[] args) {
		System.out.println("Spring Boot Data JPA");
		SpringApplication.run(SpringBootDatajpa129Application.class, args);
	}

}
