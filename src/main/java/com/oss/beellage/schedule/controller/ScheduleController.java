package com.oss.beellage.schedule.controller;

import com.oss.beellage.common.dto.CommonResponse;
import com.oss.beellage.schedule.dto.ScheduleRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface ScheduleController {
    public CommonResponse<?> createSchedule(@PathVariable Long teamId,
                                            @RequestBody ScheduleRequest scheduleRequest);

    public CommonResponse<?> updateSchedule(@PathVariable Long teamId, @PathVariable Long scheduleId,
                                            @RequestBody ScheduleRequest scheduleRequest);

    public CommonResponse<?> deleteSchedule(@PathVariable Long teamId, @PathVariable Long scheduleId);

    public CommonResponse<?> getSchedules(@PathVariable Long teamId);

    public CommonResponse<?> getSchedulesByProject(@PathVariable Long teamId,
                                                   @RequestParam Long projectId);

    public CommonResponse<?> getScheduleById(@PathVariable Long id);

}
