package com.oss.beellage.schedule.dto;

import lombok.Data;

@Data
public class ScheduleRequest {
    private String title;
    private String date;
    private Long projectId;
    private Long issueId;
}
