package com.prat.apiintegrationservice;

import com.prat.apiintegrationservice.model.WeatherAPIResponse;
import com.prat.apiintegrationservice.repository.CustomTempRepo;
import com.prat.apiintegrationservice.repository.TemperatureRepository;
import com.prat.apiintegrationservice.service.TempApiServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import java.time.Duration;

public class TempApiServiceImplTest {

    @InjectMocks
    private TempApiServiceImpl tempApiServiceImpl;

    @Mock
    private RestTemplateBuilder restTemplateBuilder;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private TemperatureRepository temperatureRepository;

    @Mock
    private CustomTempRepo customTempRepo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Correctly mock the entire chain of methods in RestTemplateBuilder
        when(restTemplateBuilder.setConnectTimeout(any(Duration.class))).thenReturn(restTemplateBuilder);
        when(restTemplateBuilder.setReadTimeout(any(Duration.class))).thenReturn(restTemplateBuilder);
        when(restTemplateBuilder.basicAuthentication(anyString(), anyString())).thenReturn(restTemplateBuilder);
        when(restTemplateBuilder.build()).thenReturn(restTemplate);  // Make sure build() returns the mocked RestTemplate
    }

    @Test
    public void testGetTemperatureFromService() {
        // Arrange
        double latitude = 13.081568;
        double longitude = 77.625137;

        WeatherAPIResponse mockResponse = new WeatherAPIResponse();
        mockResponse.setVersion("1.0");
        mockResponse.setDateGenerated("2024-10-21T00:00:00Z");
        mockResponse.setStatus("success");

        // Mocking RestTemplate response
        ResponseEntity<WeatherAPIResponse> responseEntity = ResponseEntity.ok(mockResponse);
        when(restTemplate.exchange(anyString(), eq(HttpMethod.GET), isNull(), eq(WeatherAPIResponse.class)))
                .thenReturn(responseEntity);

        // Act
        WeatherAPIResponse response = tempApiServiceImpl.getTemperatureFromService(latitude, longitude);

        // Assert
        assertEquals("1.0", response.getVersion());
        assertEquals("2024-10-21T00:00:00Z", response.getDateGenerated());
        assertEquals("success", response.getStatus());

        // Verify that the RestTemplate exchange method was called once
        verify(restTemplate, times(1)).exchange(anyString(), eq(HttpMethod.GET), isNull(), eq(WeatherAPIResponse.class));
    }
}
