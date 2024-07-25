package com.oss.beellage.chat.controller;

import com.oss.beellage.chat.dto.ChatMessageDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ChatApiController {
    public ChatMessageDto sendMessage(@PathVariable Long teamId, @RequestBody ChatMessageDto chatMessageDto);

    public List<ChatMessageDto> getMessages(@PathVariable Long teamId);
}
