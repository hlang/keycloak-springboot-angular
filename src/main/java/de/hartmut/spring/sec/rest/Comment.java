package de.hartmut.spring.sec.rest;

/**
 * Created by hartmut on 09.11.16.
 */
public class Comment {

    private String id;
    private String content;

    public Comment(String id, String content) {
        this.id = id;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
