package com.oss.beellage.calendar.collection;

import com.oss.beellage.calendar.domain.Calendar;
import java.util.List;
import lombok.Data;

@Data
public class CalendarCollection {
    private List<Calendar> calendars;
}
