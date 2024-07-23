package com.oss.beellage.schedule.service;

import com.oss.beellage.schedule.Schedule;
import com.oss.beellage.schedule.dto.ScheduleRequest;
import com.oss.beellage.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public Schedule createSchedule(ScheduleRequest scheduleRequest) {
        Schedule schedule = new Schedule();
        // 코드 컴파일 에러로 인해 주석해 둡니다
//        schedule.setCalendarId(scheduleRequest.getCalendarId());
//        schedule.setProjectId(scheduleRequest.getProjectId());
//        schedule.setIssueId(scheduleRequest.getIssueId());
        schedule.setTitle(scheduleRequest.getTitle());
        schedule.setDate(scheduleRequest.getDate());
        return scheduleRepository.save(schedule);
    }

    public void updateSchedule(Long scheduleId, ScheduleRequest scheduleRequest) {
        Optional<Schedule> optionalSchedule = scheduleRepository.findById(scheduleId);
        if (optionalSchedule.isPresent()) {
            Schedule schedule = optionalSchedule.get();
            // 코드 컴파일 에러로 인해 주석해 둡니다
//            schedule.setCalendarId(scheduleRequest.getCalendarId());
//            schedule.setProjectId(scheduleRequest.getProjectId());
//            schedule.setIssueId(scheduleRequest.getIssueId());
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
