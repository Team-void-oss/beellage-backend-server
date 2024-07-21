package com.oss.beellage.team.dto;

import lombok.Data;

@Data
public class TeamRequest {
    private String name;
    private Long hostId;
    private String description;
}
