package com.oss.beellage.chat.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessageDto {
    private Long userId;
    private String sender;
    private String message;
}

