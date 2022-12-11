package com.andela.irrigationdemo;

import com.andela.irrigationdemo.controllers.IrrigationScheduleController;
import com.andela.irrigationdemo.controllers.PlotController;
import com.andela.irrigationdemo.controllers.TimeSlotController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class IrrigationDemoApplicationTests {

    @Autowired
    PlotController plotController;
    @Autowired
    TimeSlotController timeSlotController;
    @Autowired
    IrrigationScheduleController irrigationScheduleController;

    @Test
    void contextLoads() {
        Assert.notNull(plotController, "plot controller can't be loaded");
        Assert.notNull(timeSlotController, "slot controller can't be loaded");
        Assert.notNull(irrigationScheduleController, "irrigation schedule controller can't be loaded");
    }

}
