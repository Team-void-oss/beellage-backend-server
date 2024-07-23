package com.oss.beellage.issue.collection;

import com.oss.beellage.issue.Issue;

import java.util.List;

import lombok.Data;

@Data
public class IssueCollection {
    private List<Issue> issues;
}
