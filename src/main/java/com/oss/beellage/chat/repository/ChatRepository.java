package com.oss.beellage.chat.repository;

import com.oss.beellage.chat.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat, Long> {
    List<Chat> findByTeamId(Long teamId);
}

