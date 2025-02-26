package com.example.IntegrationAPI.service;

import com.example.IntegrationAPI.model.Departement;
import com.example.IntegrationAPI.model.Employee;
import com.example.IntegrationAPI.repository.DepartementRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DepartementService  {
    private final DepartementRepository departementRepository;

    private static final Set<String> EXCLUDED_DEPARTMENTS = Set.of(
            "OTH", "Appli_Groupe", "Infra_Groupe", "Innov_Groupe", "stagiaire"
    );
    public DepartementService(DepartementRepository departementRepository) {
        this.departementRepository = departementRepository;
    }

    public List<Departement> getAllDepartement() {

        List<Departement> departements = departementRepository.findAll();


        return departements.stream()
                .filter(departement -> departement.getDept_name() != null &&
                        !EXCLUDED_DEPARTMENTS.contains(departement.getDept_name()))
                .collect(Collectors.toList());
    }
}