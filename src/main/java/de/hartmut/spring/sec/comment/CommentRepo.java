package de.hartmut.spring.sec.comment;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by hartmut on 10.11.16.
 */
@Component
public class CommentRepo {
    private Map<String, Comment> commentMap;

    public CommentRepo() {
        commentMap = Stream.of("My first comment", "second comment", "another")
                .map(comment -> new Comment(UUID.randomUUID().toString(), comment))
                .collect(Collectors.toMap(Comment::getId, c -> c));
    }

    public List<Comment> getComments() {
        return new ArrayList<>(commentMap.values());
    }

    public Comment addComment(String commentStr) {
        Comment comment = new Comment(UUID.randomUUID().toString(), commentStr);
        commentMap.put(comment.getId(), comment);
        return comment;
    }

    public void delete(String id) {
        commentMap.remove(id);
    }
}
