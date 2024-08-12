//package com.oss.beellage.project.service;
//
//import com.oss.beellage.project.Project;
//import com.oss.beellage.project.dto.ProjectRequest;
//import com.oss.beellage.project.repository.ProjectRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//class ProjectServiceTests {
//
//    @Mock
//    private ProjectRepository projectRepository;
//
//    @InjectMocks
//    private ProjectServiceImpl projectService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testCreateProject() {
//        Project project = new Project();
//        project.setName("New Project");
//        project.setDescription("Project description");
//        project.setTeamId(1L);
//
//        when(projectRepository.save(any(Project.class))).thenReturn(project);
//
//        ProjectRequest request = new ProjectRequest();
//        request.setName("New Project");
//        request.setDescription("Project description");
//        request.setTeamId(1L);
//
//        Project createdProject = projectService.createProject(request);
//
//        assertEquals("New Project", createdProject.getName());
//    }
//
//    @Test
//    void testGetProjectById() {
//        Project project = new Project();
//        project.setId(1L);
//        project.setName("New Project");
//        project.setDescription("Project description");
//        project.setTeamId(1L);
//
//        when(projectRepository.findById(1L)).thenReturn(Optional.of(project));
//
//        Optional<Project> foundProject = projectService.getProjectById(1L);
//
//        assertTrue(foundProject.isPresent());
//        assertEquals(1L, foundProject.get().getId());
//    }
//}
