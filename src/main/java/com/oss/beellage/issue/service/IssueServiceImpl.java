package com.oss.beellage.issue.service;

import com.oss.beellage.issue.Issue;
import com.oss.beellage.issue.dto.IssueRequest;
import com.oss.beellage.issue.repository.IssueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IssueServiceImpl implements IssueService {

    private final IssueRepository issueRepository;

    public Issue createIssue(IssueRequest issueRequest) {
        Issue issue = new Issue();
        // 코드 컴파일 에러로 인해 주석해 둡니다
//        issue.setProjectId(issueRequest.getProjectId());
//        issue.setCreatorId(issueRequest.getCreatorId());
//        issue.setAssignedUser(issueRequest.getAssignedUser());
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
