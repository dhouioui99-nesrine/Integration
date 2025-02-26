package com.example.IntegrationAPI.controller;

import com.example.IntegrationAPI.service.iclock_transactionService;
import com.example.IntegrationAPI.service.iclock_transactionService.PointageResult;
import com.example.IntegrationAPI.model.iclock_transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")

public class iclock_transactionController {

    private final iclock_transactionService iclockTransactionService;

    @Autowired
    public iclock_transactionController(iclock_transactionService iclockTransactionService) {
        this.iclockTransactionService = iclockTransactionService;
    }

    // API pour les transactions valides
    @GetMapping("/valid-transactions")
    public List<PointageResult> getValidTransactions() {
        return iclockTransactionService.getPremierEtDernierPointageParJour();
    }

    // API pour les transactions invalides

}