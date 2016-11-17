package de.hartmut.spring.keycloak;

import de.hartmut.spring.keycloak.comment.Comment;
import de.hartmut.spring.keycloak.comment.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@SpringBootApplication
public class SpringSecDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecDemoApplication.class, args);
	}

    @Component
    public class MyBean implements CommandLineRunner {

        private final CommentRepository commentRepository;

        @Autowired
        public MyBean(CommentRepository commentRepository) {
            this.commentRepository = commentRepository;
        }

        public void run(String... args) {
            Stream.of("My first comment", "second comment", "another")
                    .map(comment -> new Comment(comment))
                    .forEach(commentRepository::save);
        }

    }
}
