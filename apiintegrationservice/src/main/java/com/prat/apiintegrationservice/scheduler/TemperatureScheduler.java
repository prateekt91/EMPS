package com.prat.apiintegrationservice.scheduler;

import com.prat.apiintegrationservice.model.GeoCoordinates;
import com.prat.apiintegrationservice.service.TempApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TemperatureScheduler {

//    private static final Logger log = LoggerFactory.getLogger(TemperatureScheduler.class);
//
//    @Autowired
//    TempApiService tempApiService;
//
//    @Scheduled(fixedRate = 900000)
//   // @Scheduled(fixedRate = 1000)
//    public void saveTempDetailsFromAPIToDB() {
//
//        String methodName = "TemperatureScheduler.getTempDetailsFromAPI";
//        log.info("Inside method {} ",methodName);
//
//        double lat= 13.081568;
//        double lon= 77.625137;
//
//        Map<String, GeoCoordinates> mapToCoordinates = new HashMap<>();
//
//        GeoCoordinates geoCoordinates = new GeoCoordinates();
//        geoCoordinates.setLat(lat);
//        geoCoordinates.setLon(lon);
//
//        mapToCoordinates.put("Bengaluru", geoCoordinates);
//
//        // TODO Get a list of Coordinates for different locations and save it to hashmap
//
//        tempApiService.
//                getTemperatureFromService(mapToCoordinates.get("Bengaluru").getLat(), mapToCoordinates.get("Bengaluru").getLon());
//    }
}
