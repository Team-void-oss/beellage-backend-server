package com.oss.beellage.project.service;

import com.oss.beellage.project.Project;
import com.oss.beellage.project.dto.ProjectRequest;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    public Project createProject(ProjectRequest projectRequest);

    public List<Project> getAllProjects();

    public Optional<Project> getProjectById(Long projectId);

}
