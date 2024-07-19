package com.oss.beellage.chat.controller;

import com.oss.beellage.chat.domain.ChatMessage;
import com.oss.beellage.chat.dto.ChatMessageDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ChatApiController {
    public ChatMessage sendMessage(@PathVariable Long teamId, @RequestBody ChatMessageDto chatMessageDto);

    public List<ChatMessage> getMessages(@PathVariable Long teamId);
}
