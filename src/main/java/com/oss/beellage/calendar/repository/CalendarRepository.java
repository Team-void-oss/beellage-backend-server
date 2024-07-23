package com.oss.beellage.calendar.repository;

import com.oss.beellage.calendar.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarRepository extends JpaRepository<Calendar, Long> {
}
