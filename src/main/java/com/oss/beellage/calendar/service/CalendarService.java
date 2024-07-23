package com.oss.beellage.calendar.service;

import com.oss.beellage.calendar.Calendar;
import com.oss.beellage.calendar.dto.CalendarRequest;

import java.util.Optional;

public interface CalendarService {
    public Calendar createCalendar(CalendarRequest calendarRequest);

    public Optional<Calendar> getCalendarById(Long id);

}
