package com.andela.irrigationdemo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity(name = "irrigation_schedule")
public class IrrigationSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "plot_id is required")
    @Min(value = 1, message = "plot_id should be greater than 0")
    private Long plot_id;

    @NotNull(message = "time_slot_id is required")
    @Min(value = 1, message = "time_slot_id should be greater than 0")
    private Long time_slot_id;

    public IrrigationSchedule() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlot_id() {
        return plot_id;
    }

    public void setPlot_id(Long plot_id) {
        this.plot_id = plot_id;
    }

    public Long getTime_slot_id() {
        return time_slot_id;
    }

    public void setTime_slot_id(Long time_slot_id) {
        this.time_slot_id = time_slot_id;
    }
}
