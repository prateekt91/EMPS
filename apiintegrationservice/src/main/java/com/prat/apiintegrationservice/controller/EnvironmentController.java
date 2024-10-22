package com.prat.apiintegrationservice.controller;

import com.prat.apiintegrationservice.model.Temperature;
import com.prat.apiintegrationservice.service.TempApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/env")
public class EnvironmentController {

    @Autowired
    TempApiService tempApiService;

    @GetMapping("/temp")
    public ResponseEntity<Temperature> getTempurature(@RequestParam double lat, @RequestParam double lon) {
        Temperature response = tempApiService.getCurrentTempurature(lat, lon);
        return ResponseEntity.ok(response);
    }
}
