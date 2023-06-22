package com.example.smartscholapp.Controller;

import com.example.smartscholapp.Model.Course;
import com.example.smartscholapp.Service.CourseService;

import org.springframework.core.io.Resource;


import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/courses")
@CrossOrigin(origins = "*")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        // Implement logic to get a course by ID
        Course course = courseService.getCourseById(id);
        if (course != null) {
            return ResponseEntity.ok(course);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Course addCourse(@RequestParam("title") String title,
                            @RequestParam("description") String description,
                            @RequestParam("pdfFile") MultipartFile pdfFile) {
        Course course = new Course();
        course.setTitle(title);
        course.setDescription(description);

        return courseService.addCourse(course, pdfFile);
    }




    @GetMapping("/pdfs/{fileName}")
    public ResponseEntity<Resource> downloadPDF(@PathVariable String fileName) {
        try {
            Path file = Paths.get("C:/Users/Dali/Downloads/pdffile/" + fileName);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() && resource.isReadable()) {
                return ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_PDF)
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (MalformedURLException e) {
            return ResponseEntity.badRequest().build();
        }
    }


    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }
    // Add additional endpoints for course-related operations as needed
}
