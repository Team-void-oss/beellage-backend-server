package com.oss.beellage.issue.collection;

import com.oss.beellage.issue.domain.Issue;
import java.util.List;

public class IssueCollection {
    private List<Issue> issues;

    public IssueCollection(List<Issue> issues) {
        this.issues = issues;
    }

    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }

    // Add methods to handle issue operations
    public void addIssue(Issue issue) {
        this.issues.add(issue);
    }

    public void removeIssue(Issue issue) {
        this.issues.remove(issue);
    }
}
