package org.store.microservice.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.store.microservice.model.MeasurementType;
import org.store.microservice.model.Summary;
import org.store.microservice.model.SummaryType;
import org.store.microservice.service.SummaryService;
import org.store.microservice.web.dto.SummaryDto;
import org.store.microservice.web.mapper.SummaryMapper;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/analytics")
public class AnalyticsController {

    private final SummaryService summaryService;
    private final SummaryMapper summaryMapper;

    @GetMapping("/summary/{sensorName}")
    public SummaryDto getSummary(
            @PathVariable String sensorName,
            @RequestParam(value = "mt", required = false)
            Set<MeasurementType> measurementTypes,
            @RequestParam(value = "st", required = false)
            Set<SummaryType> summaryTypes
    ) {
        Summary summary = summaryService.get(
                sensorName,
                measurementTypes,
                summaryTypes
        );

        return summaryMapper.toDto(summary);

    }
}
