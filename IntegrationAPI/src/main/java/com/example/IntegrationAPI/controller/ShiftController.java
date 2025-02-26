package com.example.IntegrationAPI.controller;

import com.example.IntegrationAPI.model.Shift;
import com.example.IntegrationAPI.model.Timeinterval;
import com.example.IntegrationAPI.service.ShiftService;
import com.example.IntegrationAPI.service.TimeintervalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/Shift")
public class ShiftController {
    private final ShiftService shiftService;

    public ShiftController(ShiftService shiftService ) {
        this.shiftService = shiftService;
    }

    @GetMapping
    public List<Shift> getAllShift() {
        return shiftService.getAllShift();
    }
}
