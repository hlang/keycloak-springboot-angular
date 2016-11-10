package de.hartmut.spring.sec.rest;

import de.hartmut.spring.sec.comment.Comment;
import de.hartmut.spring.sec.comment.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController()
@RequestMapping("/api")
public class MyRestCtrl {

    private final CommentRepo commentRepo;

    @Autowired
    public MyRestCtrl(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }

    List<String> comments = Arrays.asList("My first comment", "second comment", "another");
    @RequestMapping("/comment")
    public List<Comment> getAll() {
        return commentRepo.getComments();
    }

    @PostMapping("/comment")
    public ResponseEntity<Comment> addComment(@RequestBody String commentStr) {
        return ResponseEntity.ok(commentRepo.addComment(commentStr));
    }
}
