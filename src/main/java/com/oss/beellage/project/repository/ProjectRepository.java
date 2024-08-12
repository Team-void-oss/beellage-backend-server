package com.oss.beellage.project.repository;

import com.oss.beellage.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
