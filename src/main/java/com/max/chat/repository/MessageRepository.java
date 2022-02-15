package com.max.chat.repository;

import com.max.chat.entity.Message;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MessageRepository {
    private final List<Message> list = new ArrayList<>();

    public void addMessage(Message message) {
        list.add(message);
    }

    public List<Message> getMessages() {
        return list;
    }
}
