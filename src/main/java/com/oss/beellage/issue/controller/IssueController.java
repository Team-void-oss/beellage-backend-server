package com.oss.beellage.issue.controller;

import com.oss.beellage.common.dto.CommonResponse;
import com.oss.beellage.issue.dto.IssueRequest;
import org.springframework.web.bind.annotation.RequestBody;

public interface IssueController {
    CommonResponse<?> createIssue(@RequestBody IssueRequest issueRequest);

    CommonResponse<?> getAllIssues();

}
