package de.hartmut.spring.keycloak.rest;

import de.hartmut.spring.keycloak.comment.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/admin")
public class AdminRestCtrl {
    private final CommentRepo commentRepo;

    @Autowired
    public AdminRestCtrl(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }

    @DeleteMapping("/comment/{id}")
    public ResponseEntity deleteComment(@PathVariable("id") String id) {
        commentRepo.delete(id);

        return ResponseEntity.noContent().build();
    }
}
