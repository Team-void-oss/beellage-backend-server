package com.oss.beellage.issue.collection;

import com.oss.beellage.issue.domain.Issue;
import java.util.List;
import lombok.Data;

@Data
public class IssueCollection {
    private List<Issue> issues;
}
