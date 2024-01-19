package org.store.microservice.web.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.store.microservice.model.MeasurementType;
import org.store.microservice.model.Summary;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
public class SummaryDto {

    private long sensorId;
    private Map<MeasurementType, List<Summary.SummaryEntry>> values;


}

