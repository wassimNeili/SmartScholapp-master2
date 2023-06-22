package com.example.smartscholapp.Service;

import com.example.smartscholapp.Model.Course;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CourseService {


    Course getCourseById(Long id);

    Course addCourse(Course course, MultipartFile pdfFile);
    List<Course> getAllCourses();

    Course updateCourse(Course course);

    void deleteCourse(Long id);



    // Add additional methods for course management as needed
}

