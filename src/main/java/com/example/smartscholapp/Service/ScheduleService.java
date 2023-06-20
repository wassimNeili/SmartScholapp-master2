package com.example.smartscholapp.Service;


import com.example.smartscholapp.Model.Schedule;

import java.util.List;

public interface ScheduleService {
    List<Schedule> getAllSchedules();
    Schedule getScheduleById(Long id);
    Schedule createSchedule(Schedule schedule);
    Schedule updateSchedule(Schedule schedule);
    void deleteSchedule(Long id);
}
