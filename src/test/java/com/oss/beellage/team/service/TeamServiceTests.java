package com.oss.beellage.team.service;

import com.oss.beellage.team.Team;
import com.oss.beellage.team.dto.TeamRequest;
import com.oss.beellage.team.repository.TeamRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class TeamServiceTests {

    @Mock
    private TeamRepository teamRepository;

    @InjectMocks
    private TeamServiceImpl teamService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateTeam() {
        Team team = new Team();
        team.setName("New Team");
        team.setDescription("Team description");
        team.setHostId(1L);  // hostId 설정

        when(teamRepository.save(any(Team.class))).thenReturn(team);

        TeamRequest request = new TeamRequest();
        request.setName("New Team");
        request.setDescription("Team description");
        request.setHostId(1L);  // hostId 설정

        Team createdTeam = teamService.createTeam(request);

        assertEquals("New Team", createdTeam.getName());
        assertEquals("Team description", createdTeam.getDescription());
        assertEquals(1L, createdTeam.getHostId());  // hostId 검증
    }

    @Test
    void testGetTeamById() {
        Team team = new Team();
        team.setId(1L);
        team.setName("New Team");
        team.setDescription("Team description");
        team.setHostId(1L);  // hostId 설정

        when(teamRepository.findById(1L)).thenReturn(Optional.of(team));

        Optional<Team> foundTeam = teamService.getTeamById(1L);

        assertTrue(foundTeam.isPresent());
        assertEquals(1L, foundTeam.get().getId());
        assertEquals(1L, foundTeam.get().getHostId());  // hostId 검증
    }
}
