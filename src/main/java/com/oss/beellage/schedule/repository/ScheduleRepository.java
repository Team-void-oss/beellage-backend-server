package com.oss.beellage.schedule.repository;

import com.oss.beellage.schedule.domain.Schedule;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findByTeamId(Long teamId);

    List<Schedule> findByProjectId(Long projectId);
}
