package com.oss.beellage.project.controller;

import com.oss.beellage.common.dto.CommonResponse;
import com.oss.beellage.project.Project;
import com.oss.beellage.project.dto.ProjectRequest;
import com.oss.beellage.project.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.oss.beellage.common.handler.ResponseHandler.handleResponse;

@RestController
@RequestMapping("/api/v1/projects")
@RequiredArgsConstructor
public class ProjectControllerImpl implements ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public CommonResponse<?> createProject(@RequestBody ProjectRequest projectRequest) {
        Project createdProject = projectService.createProject(projectRequest);
        return handleResponse(createdProject, HttpStatus.CREATED);
    }

    @GetMapping
    public CommonResponse<?> getAllProjects() {
        List<Project> projects = projectService.getAllProjects();
        return handleResponse(projects, HttpStatus.OK);
    }
}
