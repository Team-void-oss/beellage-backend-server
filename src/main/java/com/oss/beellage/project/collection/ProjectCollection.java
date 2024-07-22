package com.oss.beellage.project.collection;

import com.oss.beellage.project.domain.Project;
import java.util.List;
import lombok.Data;

@Data
public class ProjectCollection {
    private List<Project> projects;
}
