package com.oss.beellage.schedule.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.oss.beellage.schedule.domain.Schedule;
import com.oss.beellage.schedule.dto.ScheduleRequest;
import com.oss.beellage.schedule.repository.ScheduleRepository;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class ScheduleServiceTests {

    @Mock
    private ScheduleRepository scheduleRepository;

    @InjectMocks
    private ScheduleService scheduleService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateSchedule() {
        Schedule schedule = new Schedule();
        schedule.setTitle("New Schedule");
        schedule.setDate(Timestamp.valueOf("2024-07-21 00:00:00"));
        schedule.setProjectId(1L);
        schedule.setIssueId(1L);

        when(scheduleRepository.save(any(Schedule.class))).thenReturn(schedule);

        ScheduleRequest request = new ScheduleRequest();
        request.setTitle("New Schedule");
        request.setDate(Timestamp.valueOf("2024-07-21 00:00:00"));
        request.setProjectId(1L);
        request.setIssueId(1L);

        Schedule createdSchedule = scheduleService.createSchedule(request);

        assertEquals("New Schedule", createdSchedule.getTitle());
    }

    @Test
    void testGetScheduleById() {
        Schedule schedule = new Schedule();
        schedule.setId(1L);
        schedule.setTitle("New Schedule");
        schedule.setDate(Timestamp.valueOf("2024-07-21 00:00:00"));
        schedule.setProjectId(1L);
        schedule.setIssueId(1L);

        when(scheduleRepository.findById(1L)).thenReturn(Optional.of(schedule));

        Optional<Schedule> foundSchedule = scheduleService.getScheduleById(1L);

        assertTrue(foundSchedule.isPresent());
        assertEquals(1L, foundSchedule.get().getId());
    }

    @Test
    void testGetSchedulesByTeamId() {
        Schedule schedule1 = new Schedule();
        schedule1.setId(1L);
        schedule1.setTitle("Schedule 1");
        schedule1.setDate(Timestamp.valueOf("2024-07-21 00:00:00"));
        schedule1.setProjectId(1L);
        schedule1.setIssueId(1L);

        Schedule schedule2 = new Schedule();
        schedule2.setId(2L);
        schedule2.setTitle("Schedule 2");
        schedule2.setDate(Timestamp.valueOf("2024-07-21 00:00:00"));
        schedule2.setProjectId(1L);
        schedule2.setIssueId(1L);

        List<Schedule> schedules = List.of(schedule1, schedule2);

        when(scheduleRepository.findByCalendarTeamId(1L)).thenReturn(schedules);

        List<Schedule> foundSchedules = scheduleService.getSchedules(1L);

        assertEquals(2, foundSchedules.size());
        assertEquals("Schedule 1", foundSchedules.get(0).getTitle());
        assertEquals("Schedule 2", foundSchedules.get(1).getTitle());
    }
}
