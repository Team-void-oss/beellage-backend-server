package com.oss.beellage.calendar.controller;

import com.oss.beellage.calendar.Calendar;
import com.oss.beellage.calendar.dto.CalendarRequest;
import com.oss.beellage.calendar.service.CalendarService;
import com.oss.beellage.common.dto.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.oss.beellage.common.handler.ResponseHandler.handleResponse;

@RestController
@RequestMapping("/api/v1/calendars")
@RequiredArgsConstructor
public class CalendarControllerImpl implements CalendarController {

    private final CalendarService calendarService;

    @PostMapping
    public CommonResponse<?> createCalendar(@RequestBody CalendarRequest calendarRequest) {
        Calendar createdCalendar = calendarService.createCalendar(calendarRequest);
        return handleResponse(createdCalendar, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public CommonResponse<?> getCalendarById(@PathVariable Long id) {
        Optional<Calendar> calendar = calendarService.getCalendarById(id);
//        return calendar.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
//                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        // 적절히 수정 부탁 드립니다
        return null;
    }
}
