package com.oss.beellage.issue.service;

import com.oss.beellage.issue.Issue;
import com.oss.beellage.issue.dto.IssueRequest;
import com.oss.beellage.issue.repository.IssueRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IssueService {

    @Autowired
    private IssueRepository issueRepository;

    public Issue createIssue(IssueRequest issueRequest) {
        Issue issue = new Issue();
        issue.setProjectId(issueRequest.getProjectId());
        issue.setCreatorId(issueRequest.getCreatorId());
        issue.setAssignedUser(issueRequest.getAssignedUser());
        issue.setStatus(issueRequest.getStatus());
        issue.setDescription(issueRequest.getDescription());
        return issueRepository.save(issue);
    }

    public List<Issue> getAllIssues() {
        return issueRepository.findAll();
    }

    public Optional<Issue> getIssueById(Long issueId) {
        return issueRepository.findById(issueId);
    }
}
