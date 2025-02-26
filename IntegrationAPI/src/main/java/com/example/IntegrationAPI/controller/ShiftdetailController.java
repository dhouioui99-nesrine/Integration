package com.example.IntegrationAPI.controller;


import com.example.IntegrationAPI.model.Shiftdetail;
import com.example.IntegrationAPI.service.ShiftdetailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/Shiftdetail")
public class ShiftdetailController {
    private final ShiftdetailService shiftdetailService;

    public ShiftdetailController(ShiftdetailService shiftdetailService ) {
        this.shiftdetailService = shiftdetailService;
    }

    @GetMapping
    public List<Shiftdetail> getAllShiftdetail() {
        return shiftdetailService.getAllShiftdetail();
    }
}
