package com.example.IntegrationAPI.service;


import com.example.IntegrationAPI.model.Timeinterval;

import com.example.IntegrationAPI.repository.TimeintervalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TimeintervalService {
    private final TimeintervalRepository timeintervalRepository;

    public TimeintervalService(TimeintervalRepository timeintervalRepository ) {
        this.timeintervalRepository = timeintervalRepository;
    }

    public List<Timeinterval> getAllTimeinterval() {
        return timeintervalRepository.findAll();
    }
}

