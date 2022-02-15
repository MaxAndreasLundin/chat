package com.max.chat.controller;

import com.max.chat.dto.PostMessageDto;
import com.max.chat.entity.Message;
import com.max.chat.entity.User;
import com.max.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/v1")
public class ChatController {
    private final ChatService chatService;

    @GetMapping("/users")
    public List<User> getUsers() {
        return chatService.getUsers();
    }

    @GetMapping("/messages")
    public List<Message> getMessages() {
        return chatService.getMessages();
    }

    @PostMapping("/messages")
    public List<Message> postMessage(@RequestBody PostMessageDto postMessageDto) {
        chatService.addMessage(postMessageDto);
        return chatService.getMessages();
    }
}
