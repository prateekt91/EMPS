package com.prat.apiintegrationservice.service;

import com.prat.apiintegrationservice.model.WeatherData;

public interface TempApiService {

    WeatherData getCurrentTempurature(double lat, double lon);

    WeatherData getTemperatureFromService(double lat, double lon);
}
