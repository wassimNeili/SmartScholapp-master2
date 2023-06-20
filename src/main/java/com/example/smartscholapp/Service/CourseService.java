package com.example.smartscholapp.Service;

import com.example.smartscholapp.Model.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();

    Course getCourseById(Long id);

    Course createCourse(Course course);

    Course updateCourse(Course course);

    void deleteCourse(Long id);

    // Add additional methods for course management as needed
}

