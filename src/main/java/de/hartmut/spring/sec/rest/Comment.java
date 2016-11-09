package de.hartmut.spring.sec.rest;

/**
 * Created by hartmut on 09.11.16.
 */
public class Comment {

    private String content;

    public Comment(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
