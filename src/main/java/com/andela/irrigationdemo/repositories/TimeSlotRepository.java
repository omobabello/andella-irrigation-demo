package com.andela.irrigationdemo.repositories;

import com.andela.irrigationdemo.models.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeSlotRepository extends JpaRepository<TimeSlot, Long> {
}
