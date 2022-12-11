package com.andela.irrigationdemo.repositories;

import com.andela.irrigationdemo.models.Plot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlotRepository extends JpaRepository<Plot, Long> {
}
