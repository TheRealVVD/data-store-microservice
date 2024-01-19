package org.store.microservice.service;

import org.store.microservice.model.MeasurementType;
import org.store.microservice.model.Summary;
import org.store.microservice.model.SummaryType;

import java.util.Set;

public interface SummaryService {

    Summary get(String sensorName,
                Set<MeasurementType> measurementTypes,
                Set<SummaryType> summaryTypes
    );

}
