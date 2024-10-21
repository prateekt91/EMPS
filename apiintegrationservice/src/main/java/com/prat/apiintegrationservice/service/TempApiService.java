package com.prat.apiintegrationservice.service;

import com.prat.apiintegrationservice.model.TemperatureResponse;

public interface TempApiService {

    String getCurrentTempurature(double lat, double lon);
}
