package com.oss.beellage.chat.dto;

import lombok.Getter;

@Getter
public class ChatMessageDto {
    private String sender;
    private String content;
    private Long teamId;
}

