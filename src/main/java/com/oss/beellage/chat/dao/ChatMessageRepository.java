package com.oss.beellage.chat.dao;

import com.oss.beellage.chat.domain.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    List<ChatMessage> findByTeamId(Long teamId);
}

