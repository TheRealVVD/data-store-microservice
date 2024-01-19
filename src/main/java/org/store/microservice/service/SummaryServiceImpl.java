package org.store.microservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.store.microservice.model.MeasurementType;
import org.store.microservice.model.Summary;
import org.store.microservice.model.SummaryType;
import org.store.microservice.model.exception.SensorNotFoundException;
import org.store.microservice.repository.SummaryRepo;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class SummaryServiceImpl implements SummaryService {

    private final SummaryRepo summaryRepo;

    @Override
    public Summary get(String sensorName,
                       Set<MeasurementType> measurementTypes,
                       Set<SummaryType> summaryTypes
    ) {
        return summaryRepo.findBySensorName(
                sensorName,
                measurementTypes == null ? Set.of(MeasurementType.values()) : measurementTypes,
                summaryTypes == null ? Set.of(SummaryType.values()) : summaryTypes
        )
                .orElseThrow(SensorNotFoundException::new);

    }
}
