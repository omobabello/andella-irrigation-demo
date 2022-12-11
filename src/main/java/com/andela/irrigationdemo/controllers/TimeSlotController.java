package com.andela.irrigationdemo.controllers;

import com.andela.irrigationdemo.models.TimeSlot;
import com.andela.irrigationdemo.repositories.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/time-slots")
public class TimeSlotController {

    @Autowired
    private TimeSlotRepository timeSlotRepository;

    @GetMapping
    public List<TimeSlot> getAll() {
        return timeSlotRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public TimeSlot get(@PathVariable Long id) {
        return timeSlotRepository.getReferenceById(id);
    }

}
