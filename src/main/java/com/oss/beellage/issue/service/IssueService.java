package com.oss.beellage.issue.service;

import com.oss.beellage.issue.Issue;
import com.oss.beellage.issue.dto.IssueRequest;

import java.util.List;
import java.util.Optional;

public interface IssueService {
    public Issue createIssue(IssueRequest issueRequest);

    public List<Issue> getAllIssues();

    public Optional<Issue> getIssueById(Long issueId);

}
