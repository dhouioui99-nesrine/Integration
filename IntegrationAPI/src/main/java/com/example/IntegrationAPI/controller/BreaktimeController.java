package com.example.IntegrationAPI.controller;

import com.example.IntegrationAPI.model.Breaktime;
import com.example.IntegrationAPI.service.BreaktimeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/Breaktime")
public class BreaktimeController {
    private final BreaktimeService breaktimeService;

    public BreaktimeController(BreaktimeService breaktimeService ) {
        this.breaktimeService = breaktimeService;
    }

    @GetMapping
    public List<Breaktime> getAllBreaktime() {
        return breaktimeService.getAllBreaktime();
    }
}
