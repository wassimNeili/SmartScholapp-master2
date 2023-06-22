package com.example.smartscholapp.Model;

import com.example.smartscholapp.Config.MultipartFileDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;



    @Transient // Exclude from database mapping

    private MultipartFile pdfFile;

    private String pdfFilePath;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Other course properties

    @JsonIgnore
    public MultipartFile getPdfFile() {
        return pdfFile;
    }

    public void setPdfFile(MultipartFile pdfFile) {
        this.pdfFile = pdfFile;
    }
  // Getters and setters
}

