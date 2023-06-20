package com.example.smartscholapp.DAO;


import com.example.smartscholapp.Model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    // Add custom query methods if needed
}
