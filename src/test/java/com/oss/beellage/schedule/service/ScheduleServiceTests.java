package com.oss.beellage.schedule.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.oss.beellage.schedule.domain.Schedule;
import com.oss.beellage.schedule.dto.ScheduleRequest;
import com.oss.beellage.schedule.repository.ScheduleRepository;
import java.sql.Timestamp;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class ScheduleServiceTests {

    @Mock
    private ScheduleRepository scheduleRepository;

    @InjectMocks
    private ScheduleService scheduleService;

    public ScheduleServiceTests() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateSchedule() {
        ScheduleRequest scheduleRequest = new ScheduleRequest();
        scheduleRequest.setTitle("Test Schedule");
        scheduleRequest.setDate("2023-07-20T12:00:00");
        scheduleRequest.setProjectId(1L);
        scheduleRequest.setIssueId(1L);

        Schedule schedule = new Schedule();
        schedule.setTitle(scheduleRequest.getTitle());
        schedule.setDate(Timestamp.valueOf(scheduleRequest.getDate()));
        schedule.setProjectId(scheduleRequest.getProjectId());
        schedule.setIssueId(scheduleRequest.getIssueId());

        when(scheduleRepository.save(any(Schedule.class))).thenReturn(schedule);

        Schedule createdSchedule = scheduleService.createSchedule(scheduleRequest);

        assertNotNull(createdSchedule);
        assertEquals(scheduleRequest.getTitle(), createdSchedule.getTitle());
        assertEquals(scheduleRequest.getDate(), createdSchedule.getDate().toString());
        assertEquals(scheduleRequest.getProjectId(), createdSchedule.getProjectId());
        assertEquals(scheduleRequest.getIssueId(), createdSchedule.getIssueId());

        verify(scheduleRepository, times(1)).save(any(Schedule.class));
    }

    @Test
    void testUpdateSchedule() {
        Long scheduleId = 1L;
        ScheduleRequest scheduleRequest = new ScheduleRequest();
        scheduleRequest.setTitle("Updated Schedule");
        scheduleRequest.setDate("2023-07-21T12:00:00");
        scheduleRequest.setProjectId(1L);
        scheduleRequest.setIssueId(1L);

        Schedule schedule = new Schedule();
        schedule.setId(scheduleId);
        schedule.setTitle("Test Schedule");
        schedule.setDate(Timestamp.valueOf("2023-07-20T12:00:00"));
        schedule.setProjectId(1L);
        schedule.setIssueId(1L);

        when(scheduleRepository.findById(scheduleId)).thenReturn(java.util.Optional.of(schedule));
        when(scheduleRepository.save(any(Schedule.class))).thenReturn(schedule);

        scheduleService.updateSchedule(scheduleId, scheduleRequest);

        verify(scheduleRepository, times(1)).findById(scheduleId);
        verify(scheduleRepository, times(1)).save(any(Schedule.class));
    }

    @Test
    void testDeleteSchedule() {
        Long scheduleId = 1L;

        scheduleService.deleteSchedule(scheduleId);

        verify(scheduleRepository, times(1)).deleteById(scheduleId);
    }
}
