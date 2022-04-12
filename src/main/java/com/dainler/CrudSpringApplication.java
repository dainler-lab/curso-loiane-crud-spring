package com.dainler;

import com.dainler.model.Course;
import com.dainler.repository.CourseRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(CourseRepository courseRepository) {
		return args -> {
			System.out.println("Initializing database...");
			courseRepository.deleteAll();
			Course c = new Course();
			c.setName("Angular com Spring");
			c.setCategory("front-end");
			courseRepository.save(c);
		};
	}
}
