package com.oss.beellage.project.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.oss.beellage.project.domain.Project;
import com.oss.beellage.project.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class ProjectServiceTests {

    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private ProjectService projectService;

    public ProjectServiceTests() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateProject() {
        Project project = new Project();
        project.setName("Test Project");
        project.setTeamId(1L);

        when(projectRepository.save(any(Project.class))).thenReturn(project);

        Project createdProject = projectService.createProject(project);

        assertNotNull(createdProject);
        assertEquals(project.getName(), createdProject.getName());
        assertEquals(project.getTeamId(), createdProject.getTeamId());

        verify(projectRepository, times(1)).save(any(Project.class));
    }

    @Test
    void testGetProjectById() {
        Project project = new Project();
        project.setId(1L);
        project.setName("Test Project");
        project.setTeamId(1L);

        when(projectRepository.findById(1L)).thenReturn(java.util.Optional.of(project));

        Project foundProject = projectService.getProjectById(1L);

        assertNotNull(foundProject);
        assertEquals(project.getName(), foundProject.getName());
        assertEquals(project.getTeamId(), foundProject.getTeamId());

        verify(projectRepository, times(1)).findById(1L);
    }

    @Test
    void testDeleteProject() {
        Long projectId = 1L;

        projectService.deleteProject(projectId);

        verify(projectRepository, times(1)).deleteById(projectId);
    }
}
