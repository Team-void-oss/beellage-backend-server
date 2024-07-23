package com.oss.beellage.schedule.controller;

import com.oss.beellage.common.dto.CommonResponse;
import com.oss.beellage.schedule.Schedule;
import com.oss.beellage.schedule.dto.ScheduleRequest;
import com.oss.beellage.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.oss.beellage.common.handler.ResponseHandler.handleResponse;

@RestController
@RequestMapping("/api/v1/work/teams/{teamId}/schedules")
@RequiredArgsConstructor
public class ScheduleControllerImpl implements ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public CommonResponse<?> createSchedule(@PathVariable Long teamId,
                                            @RequestBody ScheduleRequest scheduleRequest) {
        Schedule createdSchedule = scheduleService.createSchedule(scheduleRequest);
        return handleResponse(createdSchedule, HttpStatus.CREATED);
    }

    @PatchMapping("/{scheduleId}")
    public CommonResponse<?> updateSchedule(@PathVariable Long teamId, @PathVariable Long scheduleId,
                                            @RequestBody ScheduleRequest scheduleRequest) {
        scheduleService.updateSchedule(scheduleId, scheduleRequest);
        return handleResponse(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{scheduleId}")
    public CommonResponse<?> deleteSchedule(@PathVariable Long teamId, @PathVariable Long scheduleId) {
        scheduleService.deleteSchedule(scheduleId);
        return handleResponse(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public CommonResponse<?> getSchedules(@PathVariable Long teamId) {
        List<Schedule> schedules = scheduleService.getSchedules(teamId);
        return handleResponse(schedules, HttpStatus.OK);
    }

    @GetMapping(params = "projectId")
    public CommonResponse<?> getSchedulesByProject(@PathVariable Long teamId,
                                                   @RequestParam Long projectId) {
        List<Schedule> schedules = scheduleService.getSchedulesByProject(projectId);
        return handleResponse(schedules, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public CommonResponse<?> getScheduleById(@PathVariable Long id) {
        Optional<Schedule> schedule = scheduleService.getScheduleById(id);
        // 맞게 수정 부탁드립니다.
//        return schedule.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
//                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        return null;
    }
}
