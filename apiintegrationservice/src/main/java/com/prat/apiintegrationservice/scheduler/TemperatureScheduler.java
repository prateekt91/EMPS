package com.prat.apiintegrationservice.scheduler;

import com.prat.apiintegrationservice.service.TempApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TemperatureScheduler {

    private static final Logger log = LoggerFactory.getLogger(TemperatureScheduler.class);

    @Autowired
    TempApiService tempApiService;

    @Scheduled(fixedRate = 900000)
   // @Scheduled(fixedRate = 1000)
    public void saveTempDetailsFromAPIToDB() {

        String methodName = "TemperatureScheduler.getTempDetailsFromAPI";
        log.info("Inside method {} ",methodName);

        double lat= 13.081568;
        double lon= 77.625137;
        tempApiService.getTemperatureFromService(lat, lon);
    }
}
