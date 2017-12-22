package com.sbtest.messages.api.model;

import com.sbtest.messages.api.enumerate.MessageStatusType;

public class UserMessage {

    private User user;
    private MessageStatusType status;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MessageStatusType getStatus() {
        return status;
    }

    public void setStatus(MessageStatusType status) {
        this.status = status;
    }



}
