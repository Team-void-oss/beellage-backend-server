package com.oss.beellage.chat.service;

import com.oss.beellage.chat.Chat;
import com.oss.beellage.chat.repository.ChatRepository;
import com.oss.beellage.team.domain.Team;
import com.oss.beellage.team.repository.TeamRepository;
import com.oss.beellage.user.User;
import com.oss.beellage.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {
    private final ChatRepository chatMessageRepository;
    private final TeamRepository teamRepository;
    private final UserRepository userRepository;

    public ChatServiceImpl(ChatRepository chatMessageRepository, TeamRepository teamRepository, UserRepository userRepository) {
        this.chatMessageRepository = chatMessageRepository;
        this.teamRepository = teamRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Chat> getMessagesForTeam(Long teamId) {
        return chatMessageRepository.findByTeamId(teamId);
    }

    @Override
    public Chat saveMessage(Long teamId, Long userId, String content) {
        Team team = teamRepository.findById(teamId).orElseThrow(() -> new RuntimeException("Team not found"));
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        Chat message = Chat.builder()
                .message(content)
                .sender(user)
                .createdAt(LocalDateTime.now())
                .team(team)
                .build();
        return chatMessageRepository.save(message);
    }
}

