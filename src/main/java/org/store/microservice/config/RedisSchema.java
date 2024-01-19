package org.store.microservice.config;

import org.store.microservice.model.MeasurementType;

public class RedisSchema {

    //set
    public static String sensorNames() {
        return KeyHelper.getKey("sensors");
    }

    //hash with summary types
    public static String summaryKey(
            String sensorName,
            MeasurementType measurementType
    ) {
        return KeyHelper.getKey("sensors:" + sensorName.toLowerCase() + ":" + measurementType.name().toLowerCase());
    }

}
