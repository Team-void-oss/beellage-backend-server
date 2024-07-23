package com.oss.beellage.schedule.repository;

import com.oss.beellage.schedule.Schedule;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findByCalendarId(Long calendarId);

    List<Schedule> findByProjectId(Long projectId);

    @Query("SELECT s FROM Schedule s JOIN Calendar c ON s.calendarId = c.id WHERE c.teamId = :teamId")
    List<Schedule> findByCalendarTeamId(@Param("teamId") Long teamId);
}
