package com.oss.beellage.schedule.service;

import com.oss.beellage.schedule.domain.Schedule;
import com.oss.beellage.schedule.dto.ScheduleRequest;
import com.oss.beellage.schedule.repository.ScheduleRepository;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    public Schedule createSchedule(ScheduleRequest scheduleRequest) {
        Schedule schedule = new Schedule();
        schedule.setTitle(scheduleRequest.getTitle());
        schedule.setDate(Timestamp.valueOf(scheduleRequest.getDate()));
        schedule.setProjectId(scheduleRequest.getProjectId());
        schedule.setIssueId(scheduleRequest.getIssueId());
        return scheduleRepository.save(schedule);
    }

    public void updateSchedule(Long id, ScheduleRequest scheduleRequest) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow();
        schedule.setTitle(scheduleRequest.getTitle());
        schedule.setDate(Timestamp.valueOf(scheduleRequest.getDate()));
        schedule.setProjectId(scheduleRequest.getProjectId());
        schedule.setIssueId(scheduleRequest.getIssueId());
        scheduleRepository.save(schedule);
    }

    public void deleteSchedule(Long id) {
        scheduleRepository.deleteById(id);
    }

    public List<Schedule> getSchedules(Long teamId) {
        return scheduleRepository.findAll();
    }

    public List<Schedule> getSchedulesByProject(Long projectId) {
        return scheduleRepository.findByProjectId(projectId);
    }
}
