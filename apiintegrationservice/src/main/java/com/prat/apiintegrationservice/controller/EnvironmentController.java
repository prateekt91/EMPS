package com.prat.apiintegrationservice.controller;

import com.prat.apiintegrationservice.model.WeatherAPIResponse;
import com.prat.apiintegrationservice.service.TempApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/env")
public class EnvironmentController {

    @Autowired
    TempApiService tempApiService;

    @GetMapping("/getdata")
    public ResponseEntity<WeatherAPIResponse> getWeatherDataForLocation(@RequestParam double lat, @RequestParam double lon) {
        WeatherAPIResponse response = tempApiService.getTemperatureFromService(lat, lon);
        return ResponseEntity.ok(response);
    }
}
