package com.oss.beellage.issue.controller;

import com.oss.beellage.common.dto.CommonResponse;
import com.oss.beellage.issue.Issue;
import com.oss.beellage.issue.dto.IssueRequest;
import com.oss.beellage.issue.service.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.oss.beellage.common.handler.ResponseHandler.handleResponse;

@RestController
@RequestMapping("/api/v1/issues")
@RequiredArgsConstructor
public class IssueControllerImpl implements IssueController {

    private final IssueService issueService;

    @PostMapping
    public CommonResponse<?> createIssue(@RequestBody IssueRequest issueRequest) {
        Issue createdIssue = issueService.createIssue(issueRequest);
        return handleResponse(createdIssue, HttpStatus.CREATED);
    }

    @GetMapping
    public CommonResponse<?> getAllIssues() {
        List<Issue> issues = issueService.getAllIssues();
        return handleResponse(HttpStatus.OK);
    }
}
