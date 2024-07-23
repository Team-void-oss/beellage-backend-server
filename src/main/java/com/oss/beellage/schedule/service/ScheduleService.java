package com.oss.beellage.schedule.service;

import com.oss.beellage.schedule.Schedule;
import com.oss.beellage.schedule.dto.ScheduleRequest;

import java.util.List;
import java.util.Optional;

public interface ScheduleService {
    public Schedule createSchedule(ScheduleRequest scheduleRequest);

    public void updateSchedule(Long scheduleId, ScheduleRequest scheduleRequest);

    public List<Schedule> getAllSchedule();

    public void deleteSchedule(Long scheduleId);

    public List<Schedule> getSchedules(Long teamId);

    public List<Schedule> getSchedulesByProject(Long projectId);

    public Optional<Schedule> getScheduleById(Long id);
}
