package com.sbtest.messages.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


@Document(collection = "message")
public class Message implements Serializable {

    @Id
    private String id;

    private List<UserMessage> toUsers;
    private User fromUser;
    private LocalDateTime datetime;
    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<UserMessage> getToUsers() {
        return toUsers;
    }

    public void setToUsers(List<UserMessage> toUsers) {
        this.toUsers = toUsers;
    }

    public User getFromUser() {
        return fromUser;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }
}
