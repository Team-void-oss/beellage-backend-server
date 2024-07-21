package com.oss.beellage.issue.domain;

import com.oss.beellage.project.domain.Project;
import com.oss.beellage.schedule.domain.Schedule;
import com.oss.beellage.user.domain.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import lombok.Data;

@Entity
@Table(name = "issues")
@Data
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @ManyToOne
    @JoinColumn(name = "creator_id", nullable = false)
    private User creator;

    @ManyToOne
    @JoinColumn(name = "assigned_user", nullable = false)
    private User assignedUser;

    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;

    @Column(name = "deleted_at")
    private Timestamp deletedAt;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToOne(mappedBy = "issue")
    private Schedule schedule;
}