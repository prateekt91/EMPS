package com.prat.apiintegrationservice.repository;

import com.prat.apiintegrationservice.model.WeatherData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class CustomTempRepoImpl implements CustomTempRepo {

    @Autowired
    private MongoTemplate mongoTemplate;

    private static final Logger log = LoggerFactory.getLogger(CustomTempRepoImpl.class);

    @Override
    public WeatherData getLatestTemperature(double lat, double lon) {

        String methodName = "CustomTempRepoImpl.getLatestTemperature";

        log.info("Inside method: {}", methodName);

//        Query query = new Query();
//        query.addCriteria(
//                Criteria.where("data.coordinates.lat").is(lat)
//                        .and("data.coordinates.lon").is(lon))
//                        .with(Sort.by(Sort.Direction.DESC, "dateGenerated"))
//                        .limit(1);
//        log.info("Mongo Executing: {}", query);
//        return mongoTemplate.findOne(query, WeatherData.class);

  //      return tempApiService.getTemperatureFromService(lat, lon);
        return null;
    }
}
