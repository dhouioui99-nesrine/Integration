package com.example.IntegrationAPI.controller;

import com.example.IntegrationAPI.model.Breaktime;
import com.example.IntegrationAPI.model.Timeinterval;
import com.example.IntegrationAPI.service.BreaktimeService;
import com.example.IntegrationAPI.service.TimeintervalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/Timeinterval")
public class TimeintervalController {
    private final TimeintervalService timeintervalService;

    public TimeintervalController(TimeintervalService timeintervalService ) {
        this.timeintervalService = timeintervalService;
    }

    @GetMapping
    public List<Timeinterval> getAllTimeinterval() {
        return timeintervalService.getAllTimeinterval();
    }
}
