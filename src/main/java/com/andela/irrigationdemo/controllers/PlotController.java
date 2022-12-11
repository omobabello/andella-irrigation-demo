package com.andela.irrigationdemo.controllers;

import com.andela.irrigationdemo.models.Plot;
import com.andela.irrigationdemo.repositories.PlotRepository;
import com.andela.irrigationdemo.repositories.TimeSlotRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/plots")
public class PlotController {

    @Autowired
    private PlotRepository plotRepository;
    private TimeSlotRepository timeSlotRepository;

    @GetMapping
    public List<Plot> getAll() {
        return plotRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Plot get(@PathVariable Long id) {
        return plotRepository.getReferenceById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Plot create(@Valid @RequestBody final Plot plot) {
        return plotRepository.saveAndFlush(plot);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Plot update(@PathVariable Long id, @Valid @RequestBody Plot newPlot) {
        Plot plot = plotRepository.getOne(id);
        BeanUtils.copyProperties(newPlot, plot, "id");
        return plotRepository.saveAndFlush(plot);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        plotRepository.deleteById(id);
    }


}
