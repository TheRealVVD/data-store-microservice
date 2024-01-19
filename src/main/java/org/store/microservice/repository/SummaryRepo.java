package org.store.microservice.repository;

import org.store.microservice.model.MeasurementType;
import org.store.microservice.model.Summary;
import org.store.microservice.model.SummaryType;

import java.util.Optional;
import java.util.Set;

public interface SummaryRepo {

    Optional<Summary> findBySensorName(
            String sensorName,
            Set<MeasurementType> measurementTypes,
            Set<SummaryType> summaryTypes
    );

}
