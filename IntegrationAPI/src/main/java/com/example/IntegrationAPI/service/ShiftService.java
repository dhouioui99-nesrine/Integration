package com.example.IntegrationAPI.service;

import com.example.IntegrationAPI.model.Shift;
import com.example.IntegrationAPI.model.Timeinterval;
import com.example.IntegrationAPI.repository.ShiftRepository;
import com.example.IntegrationAPI.repository.TimeintervalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShiftService {

    private final ShiftRepository shiftRepository;

    public ShiftService(ShiftRepository shiftRepository) {
        this.shiftRepository = shiftRepository;
    }

    public List<Shift> getAllShift() {
        return shiftRepository.findAll();
    }
}


