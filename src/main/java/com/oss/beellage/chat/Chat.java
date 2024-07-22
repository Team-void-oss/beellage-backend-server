package com.oss.beellage.chat;

import com.oss.beellage.team.domain.Team;
import com.oss.beellage.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User sender;
}

