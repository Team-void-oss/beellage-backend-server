package com.oss.beellage.schedule.collection;

import com.oss.beellage.schedule.Schedule;

import java.util.List;

import lombok.Data;

@Data
public class ScheduleCollection {
    private List<Schedule> schedules;
}
