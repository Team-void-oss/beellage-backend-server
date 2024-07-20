package com.oss.beellage.schedule.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "schedules")
@Getter
@Setter
@NoArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Timestamp date;
    private Long projectId;
    private Long issueId;
    private Long teamId;

    public Schedule(String title, String date, Long projectId, Long issueId, Long teamId) {
        this.title = title;
        this.date = Timestamp.valueOf(date + " 00:00:00"); // Assuming date is in 'yyyy-MM-dd' format
        this.projectId = projectId;
        this.issueId = issueId;
        this.teamId = teamId;
    }

    public void setDate(String date) {
        this.date = Timestamp.valueOf(date + " 00:00:00"); // Assuming date is in 'yyyy-MM-dd' format
    }
}
