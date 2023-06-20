package com.example.smartscholapp.DAO;


import com.example.smartscholapp.Model.Formation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormationRepository extends JpaRepository<Formation, Long> {
    // Additional methods for Formation entity can be added here
}

