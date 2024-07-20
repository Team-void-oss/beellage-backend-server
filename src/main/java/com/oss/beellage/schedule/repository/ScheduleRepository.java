package com.oss.beellage.schedule.repository;

import com.oss.beellage.schedule.domain.Schedule;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findByProjectId(Long projectId);
}
