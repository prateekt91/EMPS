package com.prat.apiintegrationservice.repository;

import com.prat.apiintegrationservice.model.Temperature;

public interface CustomTempRepo {

    Temperature getLatestTemperature(double lat, double lon);
}
