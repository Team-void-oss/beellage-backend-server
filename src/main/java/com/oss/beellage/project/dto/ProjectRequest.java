package com.oss.beellage.project.dto;

import lombok.Data;

@Data
public class ProjectRequest {
    private Long teamId;
    private String name;
    private String description;
}
