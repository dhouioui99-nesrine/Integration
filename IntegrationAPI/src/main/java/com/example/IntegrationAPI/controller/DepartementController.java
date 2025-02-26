package com.example.IntegrationAPI.controller;

import com.example.IntegrationAPI.model.Departement;
import com.example.IntegrationAPI.model.Employee;
import com.example.IntegrationAPI.service.DepartementService;
import com.example.IntegrationAPI.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/Departement")
public class DepartementController    {
    private final DepartementService departementService;

public DepartementController(DepartementService departementService) {
    this.departementService = departementService;
}

@GetMapping
public List<Departement> getAllDepartement() {
    return departementService.getAllDepartement();
}
}
