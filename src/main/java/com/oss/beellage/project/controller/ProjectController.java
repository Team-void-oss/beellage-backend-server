package com.oss.beellage.project.controller;

import com.oss.beellage.common.dto.CommonResponse;
import com.oss.beellage.project.dto.ProjectRequest;
import org.springframework.web.bind.annotation.RequestBody;

public interface ProjectController {
    CommonResponse<?> createProject(@RequestBody ProjectRequest projectRequest);

    CommonResponse<?> getAllProjects();
}
