package com.oss.beellage.schedule.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduleRequest {

    private String title;
    private String date; // Assuming date is in 'yyyy-MM-dd' format
    private Long projectId;
    private Long issueId;
    private Long teamId;

    public ScheduleRequest() {
        // 기본 생성자
    }

    public ScheduleRequest(String title, String date, Long projectId, Long issueId, Long teamId) {
        this.title = title;
        this.date = date;
        this.projectId = projectId;
        this.issueId = issueId;
        this.teamId = teamId;
    }
}
