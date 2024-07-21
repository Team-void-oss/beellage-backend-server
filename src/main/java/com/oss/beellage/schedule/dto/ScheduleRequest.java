package com.oss.beellage.schedule.dto;

import java.sql.Timestamp;
import lombok.Data;

@Data
public class ScheduleRequest {
    private Long calendarId;
    private Long projectId;
    private Long issueId;
    private String title;
    private Timestamp date;
}
