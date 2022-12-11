package com.andela.irrigationdemo.controllers;

import com.andela.irrigationdemo.models.IrrigationSchedule;
import com.andela.irrigationdemo.repositories.IrrigationScheduleRepository;
import com.andela.irrigationdemo.repositories.PlotRepository;
import com.andela.irrigationdemo.repositories.TimeSlotRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/irrigation-schedule")
public class IrrigationScheduleController {

    @Autowired
    private IrrigationScheduleRepository irrigationScheduleRepository;
    @Autowired
    private PlotRepository plotRepository;

    @Autowired
    private TimeSlotRepository timeSlotRepository;

    @GetMapping
    public List<IrrigationSchedule> welcome() {
        return irrigationScheduleRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public IrrigationSchedule create(@Valid @RequestBody final IrrigationSchedule irrigationSchedule) throws MethodArgumentNotValidException {

        if (!plotRepository.existsById(irrigationSchedule.getPlot_id())) {
            throw new MethodArgumentNotValidException(null, new BeanPropertyBindingResult(irrigationSchedule, "plot_id"));
        }

        if (!timeSlotRepository.existsById(irrigationSchedule.getTime_slot_id())) {
            throw new MethodArgumentNotValidException(null, new BeanPropertyBindingResult(irrigationSchedule, "time_slot_id"));
        }

        return irrigationScheduleRepository.saveAndFlush(irrigationSchedule);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        irrigationScheduleRepository.deleteById(id);
    }

}
