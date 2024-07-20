package com.oss.beellage.issue.dto;

import lombok.Data;

@Data
public class IssueRequest {
    private String title;
    private String description;
    private Long assignedTo;
    private String status;
}
