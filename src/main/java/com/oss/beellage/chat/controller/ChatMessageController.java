package com.oss.beellage.chat.controller;

import com.oss.beellage.chat.dto.ChatMessageDto;
import org.springframework.messaging.handler.annotation.DestinationVariable;

public interface ChatMessageController {
    public void sendMessage(@DestinationVariable Long teamId, ChatMessageDto chatMessageDto);
}
