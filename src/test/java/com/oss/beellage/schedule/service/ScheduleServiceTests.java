package com.oss.beellage.schedule.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.oss.beellage.schedule.domain.Schedule;
import com.oss.beellage.schedule.dto.ScheduleRequest;
import com.oss.beellage.schedule.repository.ScheduleRepository;
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
        ScheduleRequest request = new ScheduleRequest("New Schedule", "2024-07-21", null, null, 1L);
        Schedule schedule = new Schedule("New Schedule", "2024-07-21", null, null, 1L);

        when(scheduleRepository.save(any(Schedule.class))).thenReturn(schedule);

        Schedule createdSchedule = scheduleService.createSchedule(request);

        assertEquals("New Schedule", createdSchedule.getTitle());
        assertEquals("2024-07-21 00:00:00.0", createdSchedule.getDate().toString());
        verify(scheduleRepository, times(1)).save(any(Schedule.class));
    }

    @Test
    void testUpdateSchedule() {
        ScheduleRequest request = new ScheduleRequest("Updated Schedule", "2024-07-21", null, null, 1L);
        Schedule existingSchedule = new Schedule("Existing Schedule", "2024-07-21", null, null, 1L);

        when(scheduleRepository.findById(anyLong())).thenReturn(Optional.of(existingSchedule));
        when(scheduleRepository.save(any(Schedule.class))).thenReturn(existingSchedule);

        scheduleService.updateSchedule(1L, request);

        assertEquals("Updated Schedule", existingSchedule.getTitle());
        verify(scheduleRepository, times(1)).findById(anyLong());
        verify(scheduleRepository, times(1)).save(any(Schedule.class));
    }

    @Test
    void testUpdateSchedule_NotFound() {
        ScheduleRequest request = new ScheduleRequest("Updated Schedule", "2024-07-21", null, null, 1L);

        when(scheduleRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> scheduleService.updateSchedule(1L, request));
        verify(scheduleRepository, times(1)).findById(anyLong());
    }
}
