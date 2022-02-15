package com.max.chat.service;

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
    }

    public List<User> getUsers() {
        return userRepository.getUsers();
    }
}
