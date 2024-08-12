package com.oss.beellage.calendar.controller;

import com.oss.beellage.calendar.dto.CalendarRequest;
import com.oss.beellage.common.dto.CommonResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface CalendarController {
    CommonResponse<?> createCalendar(@RequestBody CalendarRequest calendarRequest);

    @GetMapping("/{id}")
    CommonResponse<?> getCalendarById(@PathVariable Long id);
}
