package com.example.smartscholapp.DAO;

import com.example.smartscholapp.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
    // Add custom query methods if needed
}

