package com.oss.beellage.issue.service;

import com.oss.beellage.issue.domain.Issue;
import com.oss.beellage.issue.dto.IssueRequest;
import com.oss.beellage.issue.repository.IssueRepository;
import java.sql.Timestamp;
import java.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IssueService {
    @Autowired
    private IssueRepository issueRepository;

    public Issue createIssue(IssueRequest issueRequest) {
        Issue issue = new Issue();
        issue.setTitle(issueRequest.getTitle());
        issue.setDescription(issueRequest.getDescription());
        issue.setAssignedTo(issueRequest.getAssignedTo());
        issue.setStatus(issueRequest.getStatus());
        issue.setCreatedAt(Timestamp.from(Instant.now()));
        return issueRepository.save(issue);
    }

    public void updateIssue(Long id, IssueRequest issueRequest) {
        Issue issue = issueRepository.findById(id).orElseThrow();
        issue.setTitle(issueRequest.getTitle());
        issue.setDescription(issueRequest.getDescription());
        issue.setAssignedTo(issueRequest.getAssignedTo());
        issue.setStatus(issueRequest.getStatus());
        issue.setUpdatedAt(Timestamp.from(Instant.now()));
        issueRepository.save(issue);
    }

    public void deleteIssue(Long id) {
        Issue issue = issueRepository.findById(id).orElseThrow();
        issue.setDeletedAt(Timestamp.from(Instant.now()));
        issueRepository.save(issue);
    }
}
