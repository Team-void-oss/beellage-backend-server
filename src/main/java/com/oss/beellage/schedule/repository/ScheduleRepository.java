package com.oss.beellage.schedule.repository;

import com.oss.beellage.schedule.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findByCalendarId(Long calendarId);

    List<Schedule> findByProjectId(Long projectId);

    //    @Query("SELECT s FROM Schedule s JOIN Calendar c ON s.calendarId = c.id WHERE c.teamId = :teamId")
    // 컴파일 에러가 발생하여 주석 처리해 두었습니다
    List<Schedule> findByCalendarTeamId(@Param("teamId") Long teamId);
}
