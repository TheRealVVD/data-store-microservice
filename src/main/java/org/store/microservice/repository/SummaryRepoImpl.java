package org.store.microservice.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.store.microservice.config.RedisSchema;
import org.store.microservice.model.MeasurementType;
import org.store.microservice.model.Summary;
import org.store.microservice.model.SummaryType;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Optional;
import java.util.Set;

@Repository
@RequiredArgsConstructor
public class SummaryRepoImpl implements SummaryRepo {

    private final JedisPool jedisPool;

    @Override
    public Optional<Summary> findBySensorName(
            String sensorName,
            Set<MeasurementType> measurementTypes,
            Set<SummaryType> summaryTypes
    ) {
        try(Jedis jedis = jedisPool.getResource()) {
            if(!jedis.sismember(
                    RedisSchema.sensorNames(),
                    sensorName
            )) {
                return Optional.empty();
            }
            if(measurementTypes.isEmpty() && !summaryTypes.isEmpty()) {
                return getSummary(
                        sensorName,
                        Set.of(MeasurementType.values()),
                        summaryTypes,
                        jedis
                );
            } else if (!measurementTypes.isEmpty() && summaryTypes.isEmpty()) {
                return getSummary(
                        sensorName,
                        measurementTypes,
                        Set.of(SummaryType.values()),
                        jedis
                );
            } else {
                return getSummary(
                        sensorName,
                        measurementTypes,
                        summaryTypes,
                        jedis
                );
            }
        }
    }

    private Optional<Summary> getSummary(
            String sensorName,
            Set<MeasurementType> measurementTypes,
            Set<SummaryType> summaryTypes,
            Jedis jedis
    ) {
        Summary summary = new Summary();
        summary.setSensorName(sensorName);
        for(MeasurementType mType : measurementTypes) {
            for(SummaryType sType : summaryTypes) {
                Summary.SummaryEntry entry = new Summary.SummaryEntry();
                entry.setType(sType);

                String value = jedis.hget(
                        RedisSchema.summaryKey(sensorName, mType),
                        sType.name().toLowerCase()
                );
                if(value != null) {
                    entry.setValue(Double.parseDouble(value));
                }
                summary.addValue(mType, entry);
            }
        }

        return Optional.of(summary);

    }
}
