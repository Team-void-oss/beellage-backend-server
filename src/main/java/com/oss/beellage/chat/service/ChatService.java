package com.oss.beellage.chat.service;

import com.oss.beellage.chat.domain.ChatMessage;

import java.util.List;

public interface ChatService {
    public ChatMessage saveMessage(Long teamId, String sender, String content);

    public List<ChatMessage> getMessagesForTeam(Long teamId);
}
