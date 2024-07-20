package com.oss.beellage.schedule.service;

import com.oss.beellage.schedule.domain.Schedule;
import com.oss.beellage.schedule.dto.ScheduleRequest;
import com.oss.beellage.schedule.repository.ScheduleRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    public Schedule createSchedule(ScheduleRequest request) {
        validateRequest(request);
        Schedule schedule = new Schedule(request.getTitle(), request.getDate(), request.getProjectId(),
                request.getIssueId(), request.getTeamId());
        return scheduleRepository.save(schedule);
    }

    public void updateSchedule(Long scheduleId, ScheduleRequest request) {
        validateRequest(request);
        Optional<Schedule> optionalSchedule = scheduleRepository.findById(scheduleId);
        if (optionalSchedule.isPresent()) {
            Schedule schedule = optionalSchedule.get();
            schedule.setTitle(request.getTitle());
            schedule.setDate(request.getDate());
            schedule.setProjectId(request.getProjectId());
            schedule.setIssueId(request.getIssueId());
            schedule.setTeamId(request.getTeamId());
            scheduleRepository.save(schedule);
        } else {
            throw new IllegalArgumentException("Schedule not found");
        }
    }

    public void deleteSchedule(Long scheduleId) {
        scheduleRepository.deleteById(scheduleId);
    }

    public List<Schedule> getSchedules(Long teamId) {
        return scheduleRepository.findByTeamId(teamId);
    }

    public List<Schedule> getSchedulesByProject(Long projectId) {
        return scheduleRepository.findByProjectId(projectId);
    }

    private void validateRequest(ScheduleRequest request) {
        if (request.getTitle() == null || request.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Title is required");
        }
        if (request.getDate() == null || request.getDate().isEmpty()) {
            throw new IllegalArgumentException("Date is required");
        }
    }
}
