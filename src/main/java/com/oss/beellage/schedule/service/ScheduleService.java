package com.oss.beellage.schedule.service;

import com.oss.beellage.schedule.domain.Schedule;
import com.oss.beellage.schedule.dto.ScheduleRequest;
import com.oss.beellage.schedule.repository.ScheduleRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    public Schedule createSchedule(ScheduleRequest scheduleRequest) {
        Schedule schedule = new Schedule();
        schedule.setCalendarId(scheduleRequest.getCalendarId());
        schedule.setProjectId(scheduleRequest.getProjectId());
        schedule.setIssueId(scheduleRequest.getIssueId());
        schedule.setTitle(scheduleRequest.getTitle());
        schedule.setDate(scheduleRequest.getDate());
        return scheduleRepository.save(schedule);
    }

    public void updateSchedule(Long scheduleId, ScheduleRequest scheduleRequest) {
        Optional<Schedule> optionalSchedule = scheduleRepository.findById(scheduleId);
        if (optionalSchedule.isPresent()) {
            Schedule schedule = optionalSchedule.get();
            schedule.setCalendarId(scheduleRequest.getCalendarId());
            schedule.setProjectId(scheduleRequest.getProjectId());
            schedule.setIssueId(scheduleRequest.getIssueId());
            schedule.setTitle(scheduleRequest.getTitle());
            schedule.setDate(scheduleRequest.getDate());
            scheduleRepository.save(schedule);
        } else {
            throw new RuntimeException("Schedule not found");
        }
    }

    public List<Schedule> getAllSchedule() {
        return scheduleRepository.findAll();
    }

    public void deleteSchedule(Long scheduleId) {
        scheduleRepository.deleteById(scheduleId);
    }

    public List<Schedule> getSchedules(Long teamId) {
        return scheduleRepository.findByCalendarTeamId(teamId);
    }

    public List<Schedule> getSchedulesByProject(Long projectId) {
        return scheduleRepository.findByProjectId(projectId);
    }

    public Optional<Schedule> getScheduleById(Long id) {
        return scheduleRepository.findById(id);
    }
}
