package de.hartmut.spring.sec.comment;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class CommentRepo {
    private List<Comment> comments;

    public CommentRepo() {
        comments = Stream.of("My first comment", "second comment", "another")
                .map(comment -> new Comment(UUID.randomUUID().toString(), comment))
                .collect(Collectors.toList());
    }

    public List<Comment> getComments() {
        return comments;
    }

    public Comment addComment(String commentStr) {
        Comment comment = new Comment(UUID.randomUUID().toString(), commentStr);
        comments.add(comment);
        return comment;
    }

    public void delete(String id) {
        comments.removeIf(comment -> comment.getId().equals(id));
    }
}
