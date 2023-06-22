package com.example.smartscholapp.serviceImpl;

import com.example.smartscholapp.Service.CourseService;
import com.example.smartscholapp.Model.Course;
import com.example.smartscholapp.DAO.CourseRepository;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }



    @Override
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }


    public Course addCourse(Course course, MultipartFile pdfFile) {
        String fileName = UUID.randomUUID().toString();
        String fileExtension = FilenameUtils.getExtension(pdfFile.getOriginalFilename());
        String filePath = "C:/Users/Dali/Downloads/pdffile/" + fileName + "." + fileExtension;

        try {
            pdfFile.transferTo(new File(filePath));
            course.setPdfFilePath(filePath); // Utilisez setPdfFilePath pour définir le chemin du fichier
        } catch (IOException e) {
            // Gérez l'exception
        }

        return courseRepository.save(course);
    }

    // Implement additional methods for course management as needed
}
