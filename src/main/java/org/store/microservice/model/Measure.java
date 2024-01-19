package org.store.microservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Measure {

    private Integer id;

    private Double value;

    private Boolean raining;

    private LocalDateTime measurementDateTime;

    private String sensorName;

}
