package com.oss.beellage.team.service;

import com.oss.beellage.team.Team;
import com.oss.beellage.team.dto.TeamRequest;

import java.util.List;
import java.util.Optional;

public interface TeamService {
    public Team createTeam(TeamRequest teamRequest);

    public List<Team> getAllTeams();

    public Optional<Team> getTeamById(Long id);
}
