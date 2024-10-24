package com.prat.apiintegrationservice;

import com.prat.apiintegrationservice.controller.EnvironmentController;
import com.prat.apiintegrationservice.model.WeatherAPIResponse;
import com.prat.apiintegrationservice.service.TempApiService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class EnvironmentControllerTest {


    @InjectMocks
    private EnvironmentController environmentController;

    @Mock
    private TempApiService tempApiService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetWeatherDataForLocation() {
        // Arrange
        double latitude = 13.081568;
        double longitude = 77.625137;

        // Creating mock PosData
        WeatherAPIResponse.Data.PosData posData = new WeatherAPIResponse.Data.PosData();
        posData.setDate("2024-10-21T00:00:00Z");
        posData.setValue("22.2");

        // Creating mock Coordinate
        WeatherAPIResponse.Data.Coordinate coordinate = new WeatherAPIResponse.Data.Coordinate();
        coordinate.setLat(latitude);
        coordinate.setLon(longitude);
        List<WeatherAPIResponse.Data.PosData> posDataList = new ArrayList<>();
        posDataList.add(posData);
        coordinate.setDates(posDataList);

        // Creating mock Data
        WeatherAPIResponse.Data data = new WeatherAPIResponse.Data();
        data.setParameter("t_2m:C");
        List<WeatherAPIResponse.Data.Coordinate> coordinateList = new ArrayList<>();
        coordinateList.add(coordinate);
        data.setCoordinates(coordinateList);

        // Creating mock WeatherAPIResponse
        WeatherAPIResponse mockResponse = new WeatherAPIResponse();
        mockResponse.setVersion("1.0");
        mockResponse.setDateGenerated("2024-10-21T00:00:00Z");
        mockResponse.setStatus("success");
        List<WeatherAPIResponse.Data> dataList = new ArrayList<>();
        dataList.add(data);
        mockResponse.setData(dataList);

        // Mocking the TempApiService behavior
        when(tempApiService.getTemperatureFromService(latitude, longitude))
                .thenReturn(mockResponse);

        // Act
        ResponseEntity<WeatherAPIResponse> response = environmentController.getWeatherDataForLocation(latitude, longitude);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(mockResponse, response.getBody());
    }
}
