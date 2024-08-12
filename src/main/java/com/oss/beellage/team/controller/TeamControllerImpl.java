package com.oss.beellage.team.controller;

import com.oss.beellage.common.dto.CommonResponse;
import com.oss.beellage.team.Team;
import com.oss.beellage.team.dto.TeamRequest;
import com.oss.beellage.team.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.oss.beellage.common.handler.ResponseHandler.handleResponse;

@RestController
@RequestMapping("/api/v1/teams")
@RequiredArgsConstructor
public class TeamControllerImpl implements TeamController {

    private final TeamService teamService;

    @PostMapping
    public CommonResponse<?> createTeam(@RequestBody TeamRequest teamRequest) {
        Team createdTeam = teamService.createTeam(teamRequest);
        return handleResponse(createdTeam, HttpStatus.CREATED);
    }

    @GetMapping
    public CommonResponse<?> getAllTeams() {
        List<Team> teams = teamService.getAllTeams();
        return handleResponse(teams, HttpStatus.OK);
    }
}
