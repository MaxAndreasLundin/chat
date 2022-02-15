package com.max.chat.controller;

import com.max.chat.entity.User;
import com.max.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/v1/user")
public class ChatController {
    private final ChatService chatService;

    @GetMapping
    public List<User> getUser() {
        return chatService.getUsers();
    }
}
