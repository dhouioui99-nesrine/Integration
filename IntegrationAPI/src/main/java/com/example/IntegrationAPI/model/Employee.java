package com.example.IntegrationAPI.model;


import jakarta.persistence.*;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name="personnel_employee")
public class Employee {

    @Id
    private Long id;

    private String emp_code;
    private String first_name;
    private String last_name;
    private String email;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Departement department;
    public Employee() {

    }

    public Employee(Long id, String emp_code, String first_name, String last_name, String email, Departement department) {
        this.id = id;
        this.emp_code = emp_code;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.department = department;
    }

    public Departement getDepartment() {
        return department;
    }

    public Long getId() {
        return id;
    }

    public String getEmp_code() {
        return emp_code;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }
}
