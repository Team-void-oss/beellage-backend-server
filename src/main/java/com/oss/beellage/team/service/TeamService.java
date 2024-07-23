package com.oss.beellage.team.service;

import com.oss.beellage.team.Team;
import com.oss.beellage.team.dto.TeamRequest;
import com.oss.beellage.team.repository.TeamRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public Team createTeam(TeamRequest teamRequest) {
        Team team = new Team();
        team.setName(teamRequest.getName());
        team.setHostId(teamRequest.getHostId());
        team.setDescription(teamRequest.getDescription());
        return teamRepository.save(team);
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Optional<Team> getTeamById(Long id) {
        return teamRepository.findById(id);
    }
}
