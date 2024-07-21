package com.oss.beellage.issue.dto;

import lombok.Data;

@Data
public class IssueRequest {
    private Long projectId;
    private Long creatorId;
    private Long assignedUser;
    private Integer status;
    private String description;
}
