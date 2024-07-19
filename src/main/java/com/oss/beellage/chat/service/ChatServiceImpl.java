package com.oss.beellage.chat.service;

import com.oss.beellage.chat.dao.ChatMessageRepository;
import com.oss.beellage.chat.domain.ChatMessage;
import com.oss.beellage.team.dao.TeamRepository;
import com.oss.beellage.team.domain.Team;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {
    private final ChatMessageRepository chatMessageRepository;
    private final TeamRepository teamRepository;

    public ChatServiceImpl(ChatMessageRepository chatMessageRepository, TeamRepository teamRepository) {
        this.chatMessageRepository = chatMessageRepository;
        this.teamRepository = teamRepository;
    }

    @Override
    public List<ChatMessage> getMessagesForTeam(Long teamId) {
        return chatMessageRepository.findByTeamId(teamId);
    }

    @Override
    public ChatMessage saveMessage(Long teamId, String sender, String content) {
        Team team = teamRepository.findById(teamId).orElseThrow(() -> new RuntimeException("Team not found"));
        ChatMessage message = ChatMessage.builder()
                .content(content)
                .sender(sender)
                .timestamp(LocalDateTime.now())
                .team(team)
                .build();
        return chatMessageRepository.save(message);
    }
}

