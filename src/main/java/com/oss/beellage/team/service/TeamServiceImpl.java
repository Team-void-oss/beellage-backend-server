package com.oss.beellage.team.service;

import com.oss.beellage.team.Team;
import com.oss.beellage.team.dto.TeamRequest;
import com.oss.beellage.team.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

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
