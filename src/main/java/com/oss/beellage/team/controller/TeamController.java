package com.oss.beellage.team.controller;

import com.oss.beellage.common.dto.CommonResponse;
import com.oss.beellage.team.dto.TeamRequest;
import org.springframework.web.bind.annotation.RequestBody;

public interface TeamController {
    public CommonResponse<?> createTeam(@RequestBody TeamRequest teamRequest);

    public CommonResponse<?> getAllTeams();
}
