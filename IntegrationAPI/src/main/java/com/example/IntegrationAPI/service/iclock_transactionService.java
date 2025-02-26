package com.example.IntegrationAPI.service;

import com.example.IntegrationAPI.model.Employee;
import com.example.IntegrationAPI.model.iclock_transaction;
import com.example.IntegrationAPI.repository.EmployeeRepository;
import com.example.IntegrationAPI.repository.iclock_transactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class iclock_transactionService {

    private final iclock_transactionRepository iclockTransactionRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public iclock_transactionService(iclock_transactionRepository iclockTransactionRepository,
                                     EmployeeRepository employeeRepository) {
        this.iclockTransactionRepository = iclockTransactionRepository;
        this.employeeRepository = employeeRepository;
    }

    // Classe interne pour inclure nom et département
    public static class PointageResult {
        private Integer empId;
        private String emp_code;

        private String empName;

        private String deptName;
        private String date;
        private ZonedDateTime premierPointage;
        private ZonedDateTime dernierPointage;

        public PointageResult(Integer empId, String emp_code,String empName, String deptName, String date, ZonedDateTime premierPointage, ZonedDateTime dernierPointage) {
            this.empId = empId;
            this.emp_code=emp_code;
            this.empName = empName;
            this.deptName = deptName;
            this.date = date;
            this.premierPointage = premierPointage;
            this.dernierPointage = dernierPointage;
        }

        public Integer getEmpId() { return empId; }
        public String getEmp_code(){return emp_code;}
        public String getEmpName() { return empName; }
        public String getDeptName() { return deptName; }
        public String getDate() { return date; }
        public ZonedDateTime getPremierPointage() { return premierPointage; }
        public ZonedDateTime getDernierPointage() { return dernierPointage; }
    }

    public List<PointageResult> getPremierEtDernierPointageParJour() {
        List<iclock_transaction> transactions = iclockTransactionRepository.findAll();

        List<iclock_transaction> validTransactions = transactions.stream()
                .filter(tx -> tx.getEmp_id() != null && tx.getPunch_time() != null)
                .collect(Collectors.toList());

        Map<Integer, Map<String, List<iclock_transaction>>> groupedByEmpAndDate = validTransactions.stream()
                .collect(Collectors.groupingBy(
                        iclock_transaction::getEmp_id,
                        Collectors.groupingBy(tx -> tx.getPunch_time().toLocalDate().toString())
                ));

        List<PointageResult> pointageResults = new ArrayList<>();
// Liste des départements à exclure
        List<String> excludedDepartments = Arrays.asList("OTH", "Appli_Groupe", "Infra_Groupe", "Innov_Groupe", "stagiaire");

        for (Map.Entry<Integer, Map<String, List<iclock_transaction>>> empEntry : groupedByEmpAndDate.entrySet()) {
            Integer Id = empEntry.getKey();

            // Récupérer les informations de l'employé
            Employee employee = employeeRepository.findById(Long.valueOf(Id)).orElse(null);
            String emp_code = (employee != null) ? employee.getEmp_code() : "Inconnu";
            String empName = (employee != null) ? employee.getFirst_name() : "Inconnu";
            String deptName = (employee != null && employee.getDepartment() != null) ? employee.getDepartment().getDept_name() : "Inconnu";

            // Si le département de l'employé est dans la liste des départements exclus, on passe à l'employé suivant
            if (excludedDepartments.contains(deptName)) {
                continue;
            }

            for (Map.Entry<String, List<iclock_transaction>> dateEntry : empEntry.getValue().entrySet()) {
                String date = dateEntry.getKey();
                List<iclock_transaction> transactionsForDay = dateEntry.getValue();

                ZonedDateTime premierPointage = transactionsForDay.stream()
                        .min(Comparator.comparing(iclock_transaction::getPunch_time))
                        .map(iclock_transaction::getPunch_time)
                        .orElse(null);

                ZonedDateTime dernierPointage = transactionsForDay.stream()
                        .max(Comparator.comparing(iclock_transaction::getPunch_time))
                        .map(iclock_transaction::getPunch_time)
                        .orElse(null);

                // Ajout des résultats à la liste si le département n'est pas exclu
                pointageResults.add(new PointageResult(Id, emp_code, empName, deptName, date, premierPointage, dernierPointage));
            }
        }

        return pointageResults;
    }}