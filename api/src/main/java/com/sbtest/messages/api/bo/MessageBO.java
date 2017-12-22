package com.sbtest.messages.api.bo;

import com.sbtest.messages.api.dao.MessageDAO;
import com.sbtest.messages.api.enumerate.MessageStatusType;
import com.sbtest.messages.api.exception.DAOException;
import com.sbtest.messages.api.model.Message;
import com.sbtest.messages.api.model.User;
import com.sbtest.messages.api.model.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MessageBO {

    @Autowired
    MessageDAO messageDAO;

    public Message newMessage(String content, LocalDateTime dateTime, User fromUser, List<User> toUsers) throws DAOException {

        Message message = new Message();

        message.setContent(content);
        message.setDatetime(dateTime);
        message.setFromUser(fromUser);

        List<UserMessage> toUsersMessage = new ArrayList<>();
        for(User u:toUsers){
            UserMessage user = new UserMessage();
            user.setStatus(MessageStatusType.NOT_READ);
            user.setUser(u);
            toUsersMessage.add(user);
        }

        message.setToUsers(toUsersMessage);

        messageDAO.save(message);
        return message;
    }


}
