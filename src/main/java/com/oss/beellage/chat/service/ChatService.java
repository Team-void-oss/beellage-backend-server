package com.oss.beellage.chat.service;

import com.oss.beellage.chat.Chat;

import java.util.List;

public interface ChatService {
    public Chat saveMessage(Long teamId, Long userId, String content);

    public List<Chat> getMessagesForTeam(Long teamId);
}
