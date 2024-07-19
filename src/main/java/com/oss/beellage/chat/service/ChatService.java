package com.oss.beellage.chat.service;

import com.oss.beellage.chat.domain.ChatMessage;

public interface ChatService {
    public ChatMessage saveMessage(Long teamId, String sender, String content);
}
