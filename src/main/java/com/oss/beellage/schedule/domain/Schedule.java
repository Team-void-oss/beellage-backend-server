package com.oss.beellage.schedule.domain;


import com.oss.beellage.calendar.domain.Calendar;
import com.oss.beellage.issue.domain.Issue;
import com.oss.beellage.project.domain.Project;
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
@Table(name = "schedules")
@Data
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "calendar_id", nullable = false)
    private Calendar calendar;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @OneToOne
    @JoinColumn(name = "issue_id", nullable = false)
    private Issue issue;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "date", nullable = false)
    private Timestamp date;
}
