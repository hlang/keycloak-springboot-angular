package de.hartmut.spring.sec.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hartmut on 09.11.16.
 */
@RestController()
@RequestMapping("/api")
public class MyRestCtrl {

    List<String> comments = Arrays.asList("My first comment", "second comment", "another");
    @RequestMapping("/comment")
    public List<Comment> getAll() {
        return comments.stream()
                .map(comment -> new Comment(comment))
                .collect(Collectors.toList());
    }

}
