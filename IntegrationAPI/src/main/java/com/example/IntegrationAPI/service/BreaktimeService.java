package com.example.IntegrationAPI.service;

import com.example.IntegrationAPI.model.Breaktime;

import com.example.IntegrationAPI.repository.BreaktimeRepository;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BreaktimeService {
    private final BreaktimeRepository breaktimeRepository;

    public BreaktimeService(BreaktimeRepository breaktimeRepository) {
        this.breaktimeRepository = breaktimeRepository;
    }

    public List<Breaktime> getAllBreaktime() {
        return breaktimeRepository.findAll();
    }
}
