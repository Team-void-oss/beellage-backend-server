//package com.oss.beellage.calendar.service;
//
//import com.oss.beellage.calendar.Calendar;
//import com.oss.beellage.calendar.dto.CalendarRequest;
//import com.oss.beellage.calendar.repository.CalendarRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//class CalendarServiceTests {
//
//    @Mock
//    private CalendarRepository calendarRepository;
//
//    @InjectMocks
//    private CalendarServiceImpl calendarService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testCreateCalendar() {
//        Calendar calendar = new Calendar();
//        calendar.setTeamId(1L);
//
//        when(calendarRepository.save(any(Calendar.class))).thenReturn(calendar);
//
//        CalendarRequest request = new CalendarRequest();
//        request.setTeamId(1L);
//
//        Calendar createdCalendar = calendarService.createCalendar(request);
//
//        assertEquals(1L, createdCalendar.getTeamId());
//    }
//
//    @Test
//    void testGetCalendarById() {
//        Calendar calendar = new Calendar();
//        calendar.setId(1L);
//        calendar.setTeamId(1L);
//
//        when(calendarRepository.findById(1L)).thenReturn(Optional.of(calendar));
//
//        Optional<Calendar> foundCalendar = calendarService.getCalendarById(1L);
//
//        assertTrue(foundCalendar.isPresent());
//        assertEquals(1L, foundCalendar.get().getId());
//    }
//}
