package com.oss.beellage.issue.controller;

import com.oss.beellage.issue.domain.Issue;
import com.oss.beellage.issue.dto.IssueRequest;
import com.oss.beellage.issue.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/work/teams/{teamId}/projects/{projectId}/issues")
public class IssueController {
    @Autowired
    private IssueService issueService;

    @PostMapping
    public ResponseEntity<Issue> createIssue(@PathVariable Long teamId, @PathVariable Long projectId,
                                             @RequestBody IssueRequest issueRequest) {
        Issue createdIssue = issueService.createIssue(issueRequest);
        return new ResponseEntity<>(createdIssue, HttpStatus.CREATED);
    }

    @PatchMapping("/{issueId}")
    public ResponseEntity<Void> updateIssue(@PathVariable Long teamId, @PathVariable Long projectId,
                                            @PathVariable Long issueId, @RequestBody IssueRequest issueRequest) {
        issueService.updateIssue(issueId, issueRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{issueId}")
    public ResponseEntity<Void> deleteIssue(@PathVariable Long teamId, @PathVariable Long projectId,
                                            @PathVariable Long issueId) {
        issueService.deleteIssue(issueId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
