package com.max.chat.service;

import com.max.chat.dto.PostMessageDto;
import com.max.chat.entity.Message;
import com.max.chat.entity.User;
import com.max.chat.repository.MessageRepository;
import com.max.chat.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    @PostConstruct
    public void createInitialData() {
        User user1 = new User();
        user1.setId("11");
        user1.setName("Arne");
        userRepository.addUser(user1);

        User user2 = new User();
        user2.setId("22");
        user2.setName("Knut");
        userRepository.addUser(user2);

        Message message1 = new Message();
        message1.setText("Hej du är en ful fisk");
        message1.setUser(user1);
        message1.setTimestamp(1L);
        messageRepository.addMessage(message1);

        Message message2 = new Message();
        message2.setText("Du är!!!");
        message2.setUser(user2);
        message2.setTimestamp(2L);
        messageRepository.addMessage(message2);
    }

    public List<User> getUsers() {
        return userRepository.getUsers();
    }

    public User getUserById(String userId) {
        return userRepository.getUserById(userId);
    }

    public List<Message> getMessages() {
        return messageRepository.getMessages();
    }

    public void addMessage(PostMessageDto postMessageDto) {
        User user = userRepository.getUserById(postMessageDto.getUserId());

        Message message = new Message();
        message.setTimestamp(System.currentTimeMillis());
        message.setText(postMessageDto.getText());
        message.setUser(user);

        messageRepository.addMessage(message);
    }
}
