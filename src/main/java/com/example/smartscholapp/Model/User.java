package com.example.smartscholapp.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
@Inheritance(strategy = InheritanceType.JOINED)


public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String password;
    @Column(unique = true)
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String expertise;
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Course> assignedCourses = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Formation> assignedFormations = new ArrayList<>();



    // Other user properties

    // Getters and setters
}
