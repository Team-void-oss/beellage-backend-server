package com.oss.beellage.team.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.oss.beellage.team.domain.Team;
import com.oss.beellage.team.repository.TeamRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class TeamServiceTests {

    @Mock
    private TeamRepository teamRepository;

    @InjectMocks
    private TeamService teamService;

    public TeamServiceTests() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateTeam() {
        Team team = new Team();
        team.setName("Test Team");
        team.setHostId(1L);

        when(teamRepository.save(any(Team.class))).thenReturn(team);

        Team createdTeam = teamService.createTeam(team);

        assertNotNull(createdTeam);
        assertEquals(team.getName(), createdTeam.getName());
        assertEquals(team.getHostId(), createdTeam.getHostId());

        verify(teamRepository, times(1)).save(any(Team.class));
    }

    @Test
    void testGetTeamById() {
        Team team = new Team();
        team.setId(1L);
        team.setName("Test Team");
        team.setHostId(1L);

        when(teamRepository.findById(1L)).thenReturn(java.util.Optional.of(team));

        Team foundTeam = teamService.getTeamById(1L);

        assertNotNull(foundTeam);
        assertEquals(team.getName(), foundTeam.getName());
        assertEquals(team.getHostId(), foundTeam.getHostId());

        verify(teamRepository, times(1)).findById(1L);
    }

    @Test
    void testDeleteTeam() {
        Long teamId = 1L;

        teamService.deleteTeam(teamId);

        verify(teamRepository, times(1)).deleteById(teamId);
    }
}
