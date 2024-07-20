package com.oss.beellage.schedule.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.sql.Timestamp;
import lombok.Data;

@Entity
@Data
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "calendar_id")
    private Long calendarId;

    @Column(name = "project_id")
    private Long projectId;

    @Column(name = "issue_id")
    private Long issueId;

    @Column(name = "title")
    private String title;

    @Column(name = "date")
    private Timestamp date;
}
