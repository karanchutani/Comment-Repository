package com.assignment.commentapplication.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * This is CommentApplication class which includes main method.
 * @author Karan
 */
@SpringBootApplication
@EnableJpaAuditing
@ComponentScan(basePackages = {"com.assignment.commentapplication"})
@EnableJpaRepositories(basePackages = {"com.assignment.commentapplication.repository"})
@EntityScan("com.assignment.commentapplication.model")
public class CommentApplication {

	/**
	 * This is main method of CommentApplication class.
	 * @param args field.
	 */
	public static void main(String[] args) {
		SpringApplication.run(CommentApplication.class, args);
	}

}
