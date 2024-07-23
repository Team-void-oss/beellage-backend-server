package com.oss.beellage.issue.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.oss.beellage.issue.Issue;
import com.oss.beellage.issue.dto.IssueRequest;
import com.oss.beellage.issue.repository.IssueRepository;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class IssueServiceTests {

    @Mock
    private IssueRepository issueRepository;

    @InjectMocks
    private IssueService issueService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateIssue() {
        Issue issue = new Issue();
        issue.setProjectId(1L);
        issue.setCreatorId(1L);
        issue.setAssignedUser(2L);
        issue.setStatus(1);
        issue.setDescription("Issue description");

        when(issueRepository.save(any(Issue.class))).thenReturn(issue);

        IssueRequest request = new IssueRequest();
        request.setProjectId(1L);
        request.setCreatorId(1L);
        request.setAssignedUser(2L);
        request.setStatus(1);
        request.setDescription("Issue description");

        Issue createdIssue = issueService.createIssue(request);

        assertEquals("Issue description", createdIssue.getDescription());
    }

    @Test
    void testGetIssueById() {
        Issue issue = new Issue();
        issue.setId(1L);
        issue.setProjectId(1L);
        issue.setCreatorId(1L);
        issue.setAssignedUser(2L);
        issue.setStatus(1);
        issue.setDescription("Issue description");

        when(issueRepository.findById(1L)).thenReturn(Optional.of(issue));

        Optional<Issue> foundIssue = issueService.getIssueById(1L);

        assertTrue(foundIssue.isPresent());
        assertEquals(1L, foundIssue.get().getId());
    }
}
