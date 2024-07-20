package com.oss.beellage.schedule.collection;

import com.oss.beellage.schedule.domain.Schedule;
import java.util.List;

public class ScheduleCollection {
    private List<Schedule> schedules;

    public ScheduleCollection(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    // Add methods to handle schedule operations
    public void addSchedule(Schedule schedule) {
        this.schedules.add(schedule);
    }

    public void removeSchedule(Schedule schedule) {
        this.schedules.remove(schedule);
    }
}
