package com.example.IntegrationAPI.service;

import com.example.IntegrationAPI.model.Shift;
import com.example.IntegrationAPI.model.Shiftdetail;
import com.example.IntegrationAPI.repository.ShiftRepository;
import com.example.IntegrationAPI.repository.ShiftdetailRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShiftdetailService {

    private final ShiftdetailRepository shiftdetailRepository;

    public ShiftdetailService(ShiftdetailRepository shiftdetailRepository) {
        this.shiftdetailRepository = shiftdetailRepository;
    }

    public List<Shiftdetail> getAllShiftdetail() {
        return shiftdetailRepository.findAll();
    }
}
