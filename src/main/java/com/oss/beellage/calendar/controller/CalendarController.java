package com.oss.beellage.calendar.controller;

import com.oss.beellage.calendar.domain.Calendar;
import com.oss.beellage.calendar.dto.CalendarRequest;
import com.oss.beellage.calendar.service.CalendarService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/calendars")
public class CalendarController {

    @Autowired
    private CalendarService calendarService;

    @PostMapping
    public ResponseEntity<Calendar> createCalendar(@RequestBody CalendarRequest calendarRequest) {
        Calendar createdCalendar = calendarService.createCalendar(calendarRequest);
        return new ResponseEntity<>(createdCalendar, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Calendar> getCalendarById(@PathVariable Long id) {
        Optional<Calendar> calendar = calendarService.getCalendarById(id);
        return calendar.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
