package com.prat.apiintegrationservice.service;

import com.prat.apiintegrationservice.model.Temperature;

public interface TempApiService {

    Temperature getCurrentTempurature(double lat, double lon);

    Temperature getTemperatureFromService(double lat, double lon);
}
