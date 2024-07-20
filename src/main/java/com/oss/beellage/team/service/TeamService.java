package com.oss.beellage.team.service;

import com.oss.beellage.team.domain.Team;
import com.oss.beellage.team.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    public Team getTeamById(Long id) {
        return teamRepository.findById(id).orElseThrow();
    }

    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }
}
