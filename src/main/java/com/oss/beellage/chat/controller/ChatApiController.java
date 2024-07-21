package com.oss.beellage.chat.controller;

import com.oss.beellage.chat.Chat;
import com.oss.beellage.chat.dto.ChatMessageDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ChatApiController {
    public Chat sendMessage(@PathVariable Long teamId, @RequestBody ChatMessageDto chatMessageDto);

    public List<Chat> getMessages(@PathVariable Long teamId);
}
