package com.prat.apiintegrationservice.repository;

import com.prat.apiintegrationservice.model.WeatherData;

public interface CustomTempRepo {

    WeatherData getLatestTemperature(double lat, double lon);
}
