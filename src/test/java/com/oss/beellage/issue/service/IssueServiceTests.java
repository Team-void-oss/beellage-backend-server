package com.oss.beellage.issue.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.oss.beellage.issue.domain.Issue;
import com.oss.beellage.issue.dto.IssueRequest;
import com.oss.beellage.issue.repository.IssueRepository;
import java.sql.Timestamp;
import java.time.Instant;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class IssueServiceTests {

    @Mock
    private IssueRepository issueRepository;

    @InjectMocks
    private IssueService issueService;

    public IssueServiceTests() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateIssue() {
        IssueRequest issueRequest = new IssueRequest();
        issueRequest.setTitle("Test Issue");
        issueRequest.setDescription("Description");
        issueRequest.setAssignedTo(1L);
        issueRequest.setStatus("todo");

        Issue issue = new Issue();
        issue.setTitle(issueRequest.getTitle());
        issue.setDescription(issueRequest.getDescription());
        issue.setAssignedTo(issueRequest.getAssignedTo());
        issue.setStatus(issueRequest.getStatus());
        issue.setCreatedAt(Timestamp.from(Instant.now()));

        when(issueRepository.save(any(Issue.class))).thenReturn(issue);

        Issue createdIssue = issueService.createIssue(issueRequest);

        assertNotNull(createdIssue);
        assertEquals(issueRequest.getTitle(), createdIssue.getTitle());
        assertEquals(issueRequest.getDescription(), createdIssue.getDescription());
        assertEquals(issueRequest.getAssignedTo(), createdIssue.getAssignedTo());
        assertEquals(issueRequest.getStatus(), createdIssue.getStatus());

        verify(issueRepository, times(1)).save(any(Issue.class));
    }

    @Test
    void testUpdateIssue() {
        Long issueId = 1L;
        IssueRequest issueRequest = new IssueRequest();
        issueRequest.setTitle("Updated Issue");
        issueRequest.setDescription("Updated Description");
        issueRequest.setAssignedTo(1L);
        issueRequest.setStatus("doing");

        Issue issue = new Issue();
        issue.setId(issueId);
        issue.setTitle("Test Issue");
        issue.setDescription("Description");
        issue.setAssignedTo(1L);
        issue.setStatus("todo");
        issue.setCreatedAt(Timestamp.from(Instant.now()));

        when(issueRepository.findById(issueId)).thenReturn(java.util.Optional.of(issue));
        when(issueRepository.save(any(Issue.class))).thenReturn(issue);

        issueService.updateIssue(issueId, issueRequest);

        verify(issueRepository, times(1)).findById(issueId);
        verify(issueRepository, times(1)).save(any(Issue.class));
    }

    @Test
    void testDeleteIssue() {
        Long issueId = 1L;

        Issue issue = new Issue();
        issue.setId(issueId);
        issue.setTitle("Test Issue");
        issue.setDescription("Description");
        issue.setAssignedTo(1L);
        issue.setStatus("todo");
        issue.setCreatedAt(Timestamp.from(Instant.now()));

        when(issueRepository.findById(issueId)).thenReturn(java.util.Optional.of(issue));

        issueService.deleteIssue(issueId);

        verify(issueRepository, times(1)).findById(issueId);
        verify(issueRepository, times(1)).save(any(Issue.class));
    }
}
