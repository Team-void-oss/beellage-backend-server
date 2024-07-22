package com.oss.beellage.calendar.service;

import com.oss.beellage.calendar.domain.Calendar;
import com.oss.beellage.calendar.dto.CalendarRequest;
import com.oss.beellage.calendar.repository.CalendarRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalendarService {

    @Autowired
    private CalendarRepository calendarRepository;

    public Calendar createCalendar(CalendarRequest calendarRequest) {
        Calendar calendar = new Calendar();
        calendar.setTeamId(calendarRequest.getTeamId());
        return calendarRepository.save(calendar);
    }

    public Optional<Calendar> getCalendarById(Long id) {
        return calendarRepository.findById(id);
    }
}
