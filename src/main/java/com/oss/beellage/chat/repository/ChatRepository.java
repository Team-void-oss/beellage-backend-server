package com.oss.beellage.chat.repository;

import com.oss.beellage.chat.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
    List<Chat> findByTeamId(Long teamId);
}

