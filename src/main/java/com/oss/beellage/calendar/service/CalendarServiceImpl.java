package com.oss.beellage.calendar.service;

import com.oss.beellage.calendar.Calendar;
import com.oss.beellage.calendar.dto.CalendarRequest;
import com.oss.beellage.calendar.repository.CalendarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CalendarServiceImpl implements CalendarService {
    private final CalendarRepository calendarRepository;

    public Calendar createCalendar(CalendarRequest calendarRequest) {
        Calendar calendar = new Calendar();
        // 코드 컴파일 에러로 인해 주석해 둡니다
//        calendar.setTeamId(calendarRequest.getTeamId());
        return calendarRepository.save(calendar);
    }

    public Optional<Calendar> getCalendarById(Long id) {
        return calendarRepository.findById(id);
    }
}
