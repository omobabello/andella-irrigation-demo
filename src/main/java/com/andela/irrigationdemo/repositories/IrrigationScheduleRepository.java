package com.andela.irrigationdemo.repositories;

import com.andela.irrigationdemo.models.IrrigationSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IrrigationScheduleRepository extends JpaRepository<IrrigationSchedule, Long> {
}
