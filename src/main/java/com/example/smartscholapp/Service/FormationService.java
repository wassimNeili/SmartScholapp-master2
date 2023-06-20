package com.example.smartscholapp.Service;

import com.example.smartscholapp.Model.Formation;

import java.util.List;

public interface FormationService {
    List<Formation> getAllFormations();
    Formation getFormationById(Long id);
    Formation createFormation(Formation formation);
    Formation updateFormation(Formation formation);
    void deleteFormation(Long id);

    // Additional methods for Formation management can be added here
}
