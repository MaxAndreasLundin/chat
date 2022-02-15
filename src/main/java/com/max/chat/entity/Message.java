package com.max.chat.entity;

import lombok.Data;

@Data
public class Message {
    private String text;
    private User user;
    private Long timestamp;
}
