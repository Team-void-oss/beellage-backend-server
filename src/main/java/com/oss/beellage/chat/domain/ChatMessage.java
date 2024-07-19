package com.oss.beellage.chat.domain;

import com.oss.beellage.team.domain.Team;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sender;
    private String content;
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

}

