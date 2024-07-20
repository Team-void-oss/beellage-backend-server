package com.oss.beellage.project.service;

import com.oss.beellage.project.domain.Project;
import com.oss.beellage.project.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public Project getProjectById(Long id) {
        return projectRepository.findById(id).orElseThrow();
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}
