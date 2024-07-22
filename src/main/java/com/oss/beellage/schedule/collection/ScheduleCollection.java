package com.oss.beellage.schedule.collection;

import com.oss.beellage.schedule.domain.Schedule;
import java.util.List;
import lombok.Data;

@Data
public class ScheduleCollection {
    private List<Schedule> schedules;
}
