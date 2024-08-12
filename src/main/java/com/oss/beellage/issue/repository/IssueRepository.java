package com.oss.beellage.issue.repository;

import com.oss.beellage.issue.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue, Long> {
}
