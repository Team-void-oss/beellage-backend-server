package com.oss.beellage.schedule.controller;

import com.oss.beellage.schedule.domain.Schedule;
import com.oss.beellage.schedule.dto.ScheduleRequest;
import com.oss.beellage.schedule.service.ScheduleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/work/teams/{teamId}/schedules")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<Schedule> createSchedule(@PathVariable Long teamId,
                                                   @RequestBody ScheduleRequest scheduleRequest) {
        Schedule createdSchedule = scheduleService.createSchedule(scheduleRequest);
        return new ResponseEntity<>(createdSchedule, HttpStatus.CREATED);
    }

    @PatchMapping("/{scheduleId}")
    public ResponseEntity<Void> updateSchedule(@PathVariable Long teamId, @PathVariable Long scheduleId,
                                               @RequestBody ScheduleRequest scheduleRequest) {
        scheduleService.updateSchedule(scheduleId, scheduleRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{scheduleId}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long teamId, @PathVariable Long scheduleId) {
        scheduleService.deleteSchedule(scheduleId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<Schedule>> getSchedules(@PathVariable Long teamId) {
        List<Schedule> schedules = scheduleService.getSchedules(teamId);
        return new ResponseEntity<>(schedules, HttpStatus.OK);
    }

    @GetMapping(params = "projectId")
    public ResponseEntity<List<Schedule>> getSchedulesByProject(@PathVariable Long teamId,
                                                                @RequestParam Long projectId) {
        List<Schedule> schedules = scheduleService.getSchedulesByProject(projectId);
        return new ResponseEntity<>(schedules, HttpStatus.OK);
    }
}