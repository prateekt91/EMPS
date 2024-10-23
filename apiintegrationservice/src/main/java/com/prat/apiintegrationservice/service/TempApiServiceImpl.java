package com.prat.apiintegrationservice.service;

import com.prat.apiintegrationservice.model.Temperature;
import com.prat.apiintegrationservice.model.TemperatureResponse;
import com.prat.apiintegrationservice.repository.CustomTempRepo;
import com.prat.apiintegrationservice.repository.TemperatureRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.Instant;

@Service
public class TempApiServiceImpl implements TempApiService {

    @Value("${api.air-quality.base-url}")
    private String baseUrl;

    @Value("${api.air-quality.username}")
    private String apiUserName;
    @Value("${api.air-quality.password}")
    private String apiPassword;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Autowired
    private TemperatureRepository temperatureRepository;

    @Autowired
    private CustomTempRepo customTempRepo;

    private static final Logger log = LoggerFactory.getLogger(TempApiServiceImpl.class);

    @Override
    public Temperature getCurrentTempurature(double lat, double lon) {
        return customTempRepo.getLatestTemperature(lat, lon);
    }

    @Override
    public Temperature getTemperatureFromService(double lat, double lon) {

        String methodName = "TempApiServiceImpl.getTemperatureFromService";
        log.info("Inside method {} ", methodName);
        RestTemplate restTemplate = restTemplateBuilder
                .setConnectTimeout(Duration.ofSeconds(5))
                .setReadTimeout(Duration.ofSeconds(5))
                .basicAuthentication(apiUserName, apiPassword)
                .build();
        String temperatureUrl = baseUrl + "/" + Instant.now().toString() + "/t_2m:C/" + lat + "," + lon + "/json";

        log.info("Calling temp api with url: {}", temperatureUrl);

        ResponseEntity<TemperatureResponse> response = restTemplate.exchange(temperatureUrl, HttpMethod.GET, null, TemperatureResponse.class);

        if (null != response.getBody()) {

            TemperatureResponse temperatureResponse = response.getBody();
            Temperature temperature = new Temperature(temperatureResponse.getDateGenerated(), temperatureResponse.getData());
            return temperatureRepository.save(temperature);
        } else {
            return null;
        }
    }
}
