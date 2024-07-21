package com.oss.beellage.team.domain;

import com.oss.beellage.calendar.domain.Calendar;
import com.oss.beellage.project.domain.Project;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import java.util.List;
import lombok.Data;

@Entity
@Table(name = "teams")
@Data
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "host_id", nullable = false)
    private Long hostId;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;

    @Column(name = "deleted_at")
    private Timestamp deletedAt;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<Project> projects;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<Calendar> calendars;
}